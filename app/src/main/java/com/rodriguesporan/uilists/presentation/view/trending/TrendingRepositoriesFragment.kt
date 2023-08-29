package com.rodriguesporan.uilists.presentation.view.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.data.model.RepositoriesDTO
import com.rodriguesporan.uilists.data.model.RepositoryDTO
import com.rodriguesporan.uilists.presentation.adapter.DataViewAdapter
import com.rodriguesporan.uilists.presentation.mapper.DataViewMapper.convertFromRepositoryDTO
import com.rodriguesporan.uilists.presentation.model.DataView

internal class TrendingRepositoriesFragment : Fragment() {

    private var repositories: RepositoriesDTO? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repositories =
            arguments?.getParcelable(TRENDING_REPOSITORIES_FRAGMENT_ARG_PARAM_REPOSITORIES)
    }

    private fun mapRepositories(repositories: List<RepositoryDTO>): List<DataView> {
        return repositories.map { convertFromRepositoryDTO(it) }
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
        repositories?.let {
            recyclerView.adapter = DataViewAdapter(mapRepositories(it.collection))
        }
    }

    companion object {
        const val TRENDING_REPOSITORIES_FRAGMENT_TAG = "TRENDING_REPOSITORIES_FRAGMENT_TAG"
        private const val TRENDING_REPOSITORIES_FRAGMENT_ARG_PARAM_REPOSITORIES =
            "TRENDING_REPOSITORIES_FRAGMENT_ARG_PARAM_REPOSITORIES"

        @JvmStatic
        fun newInstance(
            repositories: RepositoriesDTO?
        ): Fragment = TrendingRepositoriesFragment().apply {
            arguments = Bundle().apply {
                putParcelable(TRENDING_REPOSITORIES_FRAGMENT_ARG_PARAM_REPOSITORIES, repositories)
            }
        }
    }
}
