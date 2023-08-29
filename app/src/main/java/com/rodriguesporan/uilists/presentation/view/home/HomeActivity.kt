package com.rodriguesporan.uilists.presentation.view.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.di.factories.viewmodel.HomeViewModelFactory
import com.rodriguesporan.uilists.presentation.model.HomeUiState
import com.rodriguesporan.uilists.presentation.view.following.FollowingFragment
import com.rodriguesporan.uilists.presentation.view.starred.StarredFragment
import com.rodriguesporan.uilists.presentation.view.trending.TrendingFragment

internal class HomeActivity : AppCompatActivity() {

    private val bottomNavigation: BottomNavigationView by lazy { findViewById(R.id.bottom_navigation) }
    private val placeholderContainer: ConstraintLayout by lazy { findViewById(R.id.placeholder_container) }
    private val contentContainer: ConstraintLayout by lazy { findViewById(R.id.content_container) }
    private val viewModel: HomeViewModel by viewModels { HomeViewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(
                    R.id.fragment_container,
                    TrendingFragment.newInstance(),
                    TrendingFragment.TRENDING_FRAGMENT_TAG
                )
            }
        }
        collectFlow()
        setupListeners()
        viewModel.onCreate()
    }

    private fun collectFlow() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                onUiState(it)
            }
        }
    }

    private fun onUiState(state: HomeUiState) {
        when (state) {
            HomeUiState.Loading -> {
                placeholderContainer.visibility = View.VISIBLE
                contentContainer.visibility = View.GONE
            }

            is HomeUiState.Success -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add(
                        R.id.fragment_container,
                        TrendingFragment.newInstance(),
                        TrendingFragment.TRENDING_FRAGMENT_TAG
                    )
                }
                placeholderContainer.visibility = View.GONE
                contentContainer.visibility = View.VISIBLE
            }

            else -> {
                placeholderContainer.visibility = View.GONE
                contentContainer.visibility = View.VISIBLE
            }
        }
    }

    private fun setupListeners() {
        bottomNavigation.selectedItemId = R.id.bottom_nav_item_trending
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_nav_item_trending -> {
                    replaceWithTrendingFragment()
                }
                R.id.bottom_nav_item_starred -> {
                    replaceWithStarredFragment()
                }
                R.id.bottom_nav_item_following -> {
                    replaceWithFollowingFragment()
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceWithTrendingFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container,
                TrendingFragment.newInstance(),
                TrendingFragment.TRENDING_FRAGMENT_TAG
            )
        }
    }

    private fun replaceWithStarredFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container,
                StarredFragment.newInstance(),
                StarredFragment.STARRED_FRAGMENT_TAG
            )
        }
    }

    private fun replaceWithFollowingFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container,
                FollowingFragment.newInstance(),
                FollowingFragment.FOLLOWING_FRAGMENT_TAG
            )
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}
