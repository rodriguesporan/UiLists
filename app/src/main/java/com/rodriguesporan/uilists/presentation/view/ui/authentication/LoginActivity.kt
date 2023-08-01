package com.rodriguesporan.uilists.presentation.view.ui.authentication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.data.GitHubUri.buildAuthorizeUri
import com.rodriguesporan.uilists.presentation.model.LoginUiEvent
import com.rodriguesporan.uilists.presentation.view.ui.NavHostActivity
import com.rodriguesporan.uilists.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

internal class LoginActivity : AppCompatActivity() {

    private val buttonLogin: AppCompatButton by lazy { findViewById(R.id.button_login) }
    private val viewModel: LoginViewModel by viewModels { LoginViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupListeners()
        collectStates()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        viewModel.onNewIntentUriReceived(intent?.data)
    }

    private fun setupListeners() {
        buttonLogin.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, buildAuthorizeUri())
            startActivity(intent)
        }
    }

    private fun collectStates() {
        lifecycleScope.launch {
            viewModel.uiEvent.collect { onLoginUiEvent(it) }
        }
    }

    private fun onLoginUiEvent(event: LoginUiEvent) {
        when (event) {
            LoginUiEvent.OpenTrendingScreen -> {
                startActivity(NavHostActivity.newIntent(this))
                finish()
            }
            LoginUiEvent.OpenErrorScreen -> {
                // TODO
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
