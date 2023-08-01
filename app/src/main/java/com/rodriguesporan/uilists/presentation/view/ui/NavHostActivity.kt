package com.rodriguesporan.uilists.presentation.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.presentation.view.ui.FollowingFragment.Companion.FOLLOWING_FRAGMENT_TAG
import com.rodriguesporan.uilists.presentation.view.ui.StarredFragment.Companion.STARRED_FRAGMENT_TAG
import com.rodriguesporan.uilists.presentation.view.ui.trending.TrendingFragment
import com.rodriguesporan.uilists.presentation.view.ui.trending.TrendingFragment.Companion.TRENDING_FRAGMENT_TAG

internal class NavHostActivity : AppCompatActivity() {

    private val bottomNavigation: BottomNavigationView by lazy { findViewById(R.id.bottom_navigation) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, TrendingFragment.newInstance(), TRENDING_FRAGMENT_TAG)
            }
        }
        setupListeners()
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
                TRENDING_FRAGMENT_TAG
            )
        }
    }

    private fun replaceWithStarredFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container,
                StarredFragment.newInstance(),
                STARRED_FRAGMENT_TAG
            )
        }
    }

    private fun replaceWithFollowingFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container,
                FollowingFragment.newInstance(),
                FOLLOWING_FRAGMENT_TAG
            )
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NavHostActivity::class.java)
        }
    }
}
