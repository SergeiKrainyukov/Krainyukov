package com.sergeikrainyukov.myfavoritefilms.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sergeikrainyukov.myfavoritefilms.R
import com.sergeikrainyukov.myfavoritefilms.databinding.FragmentFilmDescriptionBinding
import com.sergeikrainyukov.myfavoritefilms.databinding.FragmentFilmsListBinding

class FilmDescriptionFragment : Fragment() {
    private var filmId: Int? = null

    private lateinit var binding: FragmentFilmDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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