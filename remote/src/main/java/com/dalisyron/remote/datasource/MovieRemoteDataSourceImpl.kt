package com.dalisyron.remote.datasource

import com.dalisyron.data.datasource.MovieRemoteDataSource
import com.dalisyron.data.entity.MovieInfoEntity
import com.dalisyron.remote.mappers.toMovieEntity
import com.dalisyron.remote.api.MovieService
import com.dalisyron.remote.dto.DiscoverMoviesResponseDto
import com.dalisyron.remote.dto.GenreDto
import com.dalisyron.remote.dto.MovieGenresListResponse
import com.dalisyron.remote.dto.MovieInfoDto
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(private val movieService: MovieService) : MovieRemoteDataSource {
    override fun getDiscoverMovies(): Single<List<MovieInfoEntity>> {

        val genreMap = movieService.getMovieGenreListResponse().map { movieGenreListResponse: MovieGenresListResponse ->
            val genreMap : HashMap<Int, String> = HashMap()
            movieGenreListResponse.genres.forEach {
                genreMap[it.id] = it.name
            }
            genreMap
        }

        val movieItemsDto = movieService.getDiscoverMoviesResponse().map { discoverMoviesDto: DiscoverMoviesResponseDto ->
            discoverMoviesDto.items}

        return movieItemsDto.zipWith(
            genreMap, BiFunction<List<MovieInfoDto>, HashMap<Int, String>, Pair<List<MovieInfoDto>,HashMap<Int,String>>> {
                x,y -> x to y
            }).map { it ->
            it.first.map { item ->
                item.toMovieEntity(it.second)
            }
        }
    }

    override fun getGenreNameById(id: Int): Single<String> {
        return movieService.getMovieGenreListResponse().map {
            it -> it.genres.filter { it.id == id }.getOrNull(0)?.name
        }
    }
}