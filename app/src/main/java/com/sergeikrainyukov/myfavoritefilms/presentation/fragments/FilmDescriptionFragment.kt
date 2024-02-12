package com.sergeikrainyukov.myfavoritefilms.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.sergeikrainyukov.myfavoritefilms.MyFavoriteFilmsApp
import com.sergeikrainyukov.myfavoritefilms.R
import com.sergeikrainyukov.myfavoritefilms.databinding.FragmentFilmDescriptionBinding
import com.sergeikrainyukov.myfavoritefilms.presentation.common.collectFlow
import com.sergeikrainyukov.myfavoritefilms.presentation.viewModels.FilmDescriptionFragmentViewModel
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class FilmDescriptionFragment : Fragment() {
    private var filmId: Int? = null

    private lateinit var binding: FragmentFilmDescriptionBinding

    @Inject
    lateinit var viewModel: FilmDescriptionFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as MyFavoriteFilmsApp).appComponent.inject(this)
        arguments?.let {
            filmId = it.getInt(FILM_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filmId?.let { viewModel.init(it) }
        bindViewModel()
    }

    private fun bindViewModel() {
        collectFlow(viewModel.filmState.filterNotNull()) {
            changeVisibilityOfMainViews(true)
            changeVisibilityOfErrorViews(false)
            with(binding) {
                if (it.image.isNotBlank()) Glide.with(requireContext())
                    .load(it.image)
                    .into(filmImage)
                title.text = it.title
                description.text = it.description
                genres.text = getString(R.string.genre).plus(" ").plus(it.genres)
                countries.text = getString(R.string.country).plus(" ").plus(it.countries)
            }
        }
        collectFlow(viewModel.errorState) {
            changeVisibilityOfMainViews(false)
            changeVisibilityOfErrorViews(true)
            binding.errorBtn.apply {
                isVisible = true
                setOnClickListener {
                    filmId?.let { it1 -> viewModel.init(it1) }
                }
            }
            binding.errorMessage.isVisible = true

        }
    }

    private fun changeVisibilityOfMainViews(isVisible: Boolean) {
        binding.filmImage.isVisible = isVisible
        binding.title.isVisible = isVisible
        binding.description.isVisible = isVisible
        binding.genres.isVisible = isVisible
        binding.countries.isVisible = isVisible
    }

    private fun changeVisibilityOfErrorViews(isVisible: Boolean) {
        binding.errorMessage.isVisible = isVisible
        binding.errorBtn.isVisible = isVisible
    }

    companion object {
        const val FILM_ID = "FILM_ID"

        @JvmStatic
        fun newInstance(filmId: Int) =
            FilmDescriptionFragment().apply {
                arguments = Bundle().apply {
                    putInt(FILM_ID, filmId)
                }
            }
    }
}