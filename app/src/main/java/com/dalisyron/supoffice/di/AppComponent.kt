package com.dalisyron.supoffice.di

import com.dalisyron.supoffice.MainActivity
import com.dalisyron.supoffice.ui.detail.DetailFragment
import com.dalisyron.supoffice.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RemoteModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailFragment)
}
