package com.rodriguesporan.uilists.presentation.view.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.di.factories.viewmodel.CustomDataViewModelFactory
import com.rodriguesporan.uilists.presentation.adapter.DataViewAdapter
import com.rodriguesporan.uilists.presentation.view.custom.CustomDataViewModel
import kotlinx.coroutines.launch

internal class TrendingRepositoriesFragment : Fragment() {

    private val viewModel: CustomDataViewModel by viewModels { CustomDataViewModelFactory.create() }
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending_repositories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        collectStates()
        viewModel.getItems()
    }

    private fun collectStates() {
        lifecycleScope.launch {
            viewModel.uiState.collect { items ->
                recyclerView.adapter = DataViewAdapter(items)
            }
        }
    }

    companion object {
        const val TRENDING_REPOSITORIES_FRAGMENT_TAG = "TRENDING_REPOSITORIES_FRAGMENT_TAG"

        @JvmStatic
        fun newInstance(): Fragment = TrendingRepositoriesFragment()
    }
}
