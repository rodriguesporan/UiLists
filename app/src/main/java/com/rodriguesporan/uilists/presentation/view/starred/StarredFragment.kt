package com.rodriguesporan.uilists.presentation.view.starred

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rodriguesporan.uilists.R

internal class StarredFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_starred, container, false)
    }

    companion object {
        const val STARRED_FRAGMENT_TAG = "STARRED_FRAGMENT_TAG"

        @JvmStatic
        fun newInstance(): Fragment = StarredFragment()
    }
}