package com.rodriguesporan.uilists.presentation.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rodriguesporan.uilists.R

internal class FollowingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_following, container, false)
    }

    companion object {
        const val FOLLOWING_FRAGMENT_TAG = "FOLLOWING_FRAGMENT_TAG"

        @JvmStatic
        fun newInstance(): Fragment = FollowingFragment()
    }
}
