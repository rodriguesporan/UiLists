package com.rodriguesporan.uilists.presentation.view.ui.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rodriguesporan.uilists.R

internal class TrendingDevelopersFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending_developers, container, false)
    }

    companion object {
        const val TRENDING_DEVELOPERS_FRAGMENT_TAG = "TRENDING_DEVELOPERS_FRAGMENT_TAG"

        @JvmStatic
        fun newInstance(): Fragment = TrendingDevelopersFragment()
    }
}
