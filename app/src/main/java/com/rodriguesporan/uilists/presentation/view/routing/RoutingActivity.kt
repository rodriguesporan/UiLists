package com.rodriguesporan.uilists.presentation.view.routing

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.rodriguesporan.uilists.di.factories.RoutingViewModelFactory
import com.rodriguesporan.uilists.presentation.model.RoutingUiState
import com.rodriguesporan.uilists.presentation.view.authentication.LoginActivity
import com.rodriguesporan.uilists.presentation.view.home.HomeActivity
import kotlinx.coroutines.launch

internal class RoutingActivity : AppCompatActivity() {

    private var keepOnSplashScreen = true
    private val viewModel: RoutingViewModel by viewModels { RoutingViewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { keepOnSplashScreen }
        collectStates()
    }

    private fun collectStates() {
        lifecycleScope.launch {
            viewModel.uiState.collect { onUiState(it) }
        }
    }

    private fun onUiState(state: RoutingUiState) {
        when (state) {
            RoutingUiState.Loading -> {
                keepOnSplashScreen = true
            }
            RoutingUiState.Authorized -> {
                keepOnSplashScreen = false
                openHomeScreen()
                finish()
            }
            RoutingUiState.NotAuthenticated -> {
                keepOnSplashScreen = false
                openLoginScreen()
                finish()
            }
        }
    }

    private fun openLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }

    private fun openHomeScreen() {
        startActivity(HomeActivity.newIntent(this))
    }
}
