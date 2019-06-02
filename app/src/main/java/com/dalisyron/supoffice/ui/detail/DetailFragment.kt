package com.dalisyron.supoffice.ui.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.dalisyron.supoffice.MyApplication
import com.dalisyron.supoffice.R

class DetailFragment : Fragment() {

    private var slug: Int? = null

    val viewModelFactory: DetailViewModelFactory by lazy {
        DetailViewModelFactory()
    }

    val viewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.component.inject(this)
        this.slug = arguments?.getInt(MOVIE_ID_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "Movie id is $slug", Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val MOVIE_ID_KEY = "movie_id"

        fun create(id: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply { putInt(MOVIE_ID_KEY, id) }
            }
        }
    }
}
