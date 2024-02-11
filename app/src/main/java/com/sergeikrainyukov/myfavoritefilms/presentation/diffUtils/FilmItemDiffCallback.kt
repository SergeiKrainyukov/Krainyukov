package com.sergeikrainyukov.myfavoritefilms.presentation.diffUtils

import androidx.recyclerview.widget.DiffUtil
import com.sergeikrainyukov.myfavoritefilms.presentation.model.FilmListItem

class FilmItemDiffCallback : DiffUtil.ItemCallback<FilmListItem>() {
    override fun areItemsTheSame(oldItem: FilmListItem, newItem: FilmListItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: FilmListItem, newItem: FilmListItem) = oldItem == newItem
}