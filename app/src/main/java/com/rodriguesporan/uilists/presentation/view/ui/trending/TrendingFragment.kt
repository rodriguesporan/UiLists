package com.rodriguesporan.uilists.presentation.view.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.tabs.TabLayout
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.view.ui.trending.TrendingDevelopersFragment.Companion.TRENDING_DEVELOPERS_FRAGMENT_TAG
import com.rodriguesporan.uilists.presentation.view.ui.trending.TrendingRepositoriesFragment.Companion.TRENDING_REPOSITORIES_FRAGMENT_TAG

internal class TrendingFragment : Fragment() {

    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (savedInstanceState == null) {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.trending_fragment_container,
                    TrendingRepositoriesFragment.newInstance(),
                    TRENDING_REPOSITORIES_FRAGMENT_TAG
                )
            }
        }
        return inflater.inflate(R.layout.fragment_trending, container, false).also { view ->
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
    }

    private fun replaceWithTrendingRepositoriesFragment() {
        childFragmentManager.commit {
            replace(
                R.id.trending_fragment_container,
                TrendingRepositoriesFragment.newInstance(),
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
