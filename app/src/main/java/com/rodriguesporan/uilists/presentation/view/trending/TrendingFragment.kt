package com.rodriguesporan.uilists.presentation.view.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.google.android.material.tabs.TabLayout
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.di.factories.viewmodel.HomeViewModelFactory
import com.rodriguesporan.uilists.presentation.view.home.HomeViewModel
import com.rodriguesporan.uilists.presentation.view.trending.TrendingDevelopersFragment.Companion.TRENDING_DEVELOPERS_FRAGMENT_TAG
import com.rodriguesporan.uilists.presentation.view.trending.TrendingRepositoriesFragment.Companion.TRENDING_REPOSITORIES_FRAGMENT_TAG

internal class TrendingFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private val viewModel: HomeViewModel by activityViewModels { HomeViewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.trending_fragment_container,
                    TrendingRepositoriesFragment.newInstance(viewModel.repositories),
                    TRENDING_REPOSITORIES_FRAGMENT_TAG
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tabLayout)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> replaceWithTrendingRepositoriesFragment()
                    1 -> replaceWithTrendingDevelopersFragment()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun replaceWithTrendingRepositoriesFragment() {
        childFragmentManager.commit {
            replace(
                R.id.trending_fragment_container,
                TrendingRepositoriesFragment.newInstance(viewModel.repositories),
                TRENDING_REPOSITORIES_FRAGMENT_TAG
            )
        }
    }

    private fun replaceWithTrendingDevelopersFragment() {
        childFragmentManager.commit {
            replace(
                R.id.trending_fragment_container,
                TrendingDevelopersFragment.newInstance(),
                TRENDING_DEVELOPERS_FRAGMENT_TAG
            )
        }
    }

    companion object {
        const val TRENDING_FRAGMENT_TAG = "TRENDING_FRAGMENT_TAG"

        @JvmStatic
        fun newInstance(): Fragment = TrendingFragment()
    }
}
