package com.sergeikrainyukov.myfavoritefilms.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sergeikrainyukov.myfavoritefilms.R

class FilmDescriptionFragment : Fragment() {
    private var filmId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            filmId = it.getInt(FILM_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film_description, container, false)
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