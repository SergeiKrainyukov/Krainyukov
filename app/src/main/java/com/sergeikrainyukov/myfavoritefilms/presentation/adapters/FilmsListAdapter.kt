package com.sergeikrainyukov.myfavoritefilms.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.sergeikrainyukov.myfavoritefilms.presentation.diffUtils.FilmItemDiffCallback
import com.sergeikrainyukov.myfavoritefilms.R
import com.sergeikrainyukov.myfavoritefilms.presentation.model.FilmListItem
import com.sergeikrainyukov.myfavoritefilms.presentation.viewHolders.FilmItemViewHolder

class FilmsListAdapter : ListAdapter<FilmListItem, FilmItemViewHolder>(FilmItemDiffCallback())  {

    var addToFavoritesAction: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return FilmItemViewHolder(view, addToFavoritesAction)
    }

    override fun onBindViewHolder(holder: FilmItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}