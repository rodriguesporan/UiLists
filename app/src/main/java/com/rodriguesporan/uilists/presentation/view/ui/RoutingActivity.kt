package com.rodriguesporan.uilists.presentation.view.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.rodriguesporan.uilists.presentation.model.RoutingUiState
import com.rodriguesporan.uilists.presentation.view.ui.authentication.LoginActivity
import com.rodriguesporan.uilists.presentation.viewmodel.RoutingViewModel
import kotlinx.coroutines.launch

internal class RoutingActivity : AppCompatActivity() {

    private var keepOnSplashScreen = true
    private val viewModel: RoutingViewModel by viewModels { RoutingViewModel.Factory }

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
        startActivity(NavHostActivity.newIntent(this))
    }
}
