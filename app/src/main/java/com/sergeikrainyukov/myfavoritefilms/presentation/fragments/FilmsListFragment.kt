package com.sergeikrainyukov.myfavoritefilms.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.sergeikrainyukov.myfavoritefilms.MyFavoriteFilmsApp
import com.sergeikrainyukov.myfavoritefilms.databinding.FragmentFilmsListBinding
import com.sergeikrainyukov.myfavoritefilms.presentation.adapters.FilmsListAdapter
import com.sergeikrainyukov.myfavoritefilms.presentation.common.Navigator
import com.sergeikrainyukov.myfavoritefilms.presentation.common.collectFlow
import com.sergeikrainyukov.myfavoritefilms.presentation.viewModels.FilmsListFragmentViewModel
import javax.inject.Inject

class FilmsListFragment : Fragment() {
    private lateinit var binding: FragmentFilmsListBinding

    private lateinit var filmsAdapter: FilmsListAdapter

    @Inject
    lateinit var viewModel: FilmsListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as MyFavoriteFilmsApp).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        filmsAdapter = FilmsListAdapter(
            addToFavoritesAction = { viewModel.onClickAddToFavorites(it) },
            openFilmDescriptionAction = { openFilmsDescriptionFragment(it) }
        )
        binding.eventsRv.adapter = filmsAdapter

    }

    private fun bindViewModel() {
        collectFlow(viewModel.filmsState) {
            changeVisibilityOfMainViews(true)
            changeVisibilityOfErrorViews(false)
            filmsAdapter.submitList(it)
        }
        collectFlow(viewModel.errorState) {
            changeVisibilityOfMainViews(false)
            changeVisibilityOfErrorViews(true)
            binding.errorBtn.apply {
                setOnClickListener {
                    viewModel.init()
                }
            }

        }
    }

    private fun changeVisibilityOfMainViews(isVisible: Boolean) {
        binding.eventsRv.isVisible = isVisible
    }

    private fun changeVisibilityOfErrorViews(isVisible: Boolean) {
        binding.errorMessage.isVisible = isVisible
        binding.errorBtn.isVisible = isVisible
    }

    private fun openFilmsDescriptionFragment(filmId: Int) {
        Navigator.navigateReplaceSaveStack(
            FilmDescriptionFragment.newInstance(filmId),
            parentFragmentManager
        )
    }
}