package com.sergeikrainyukov.myfavoritefilms.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sergeikrainyukov.myfavoritefilms.presentation.diffUtils.FilmItemDiffCallback
import com.sergeikrainyukov.myfavoritefilms.R
import com.sergeikrainyukov.myfavoritefilms.presentation.model.FilmListItem
import com.sergeikrainyukov.myfavoritefilms.presentation.viewHolders.FilmItemViewHolder

class FilmsListAdapter(
    private val addToFavoritesAction: (Int) -> Unit,
    private val openFilmDescriptionAction: (Int) -> Unit
) : ListAdapter<FilmListItem, FilmItemViewHolder>(FilmItemDiffCallback())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return FilmItemViewHolder(view, addToFavoritesAction, openFilmDescriptionAction)
    }

    override fun onBindViewHolder(holder: FilmItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}