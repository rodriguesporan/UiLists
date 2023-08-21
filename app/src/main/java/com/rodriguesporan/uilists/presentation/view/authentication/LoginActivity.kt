package com.rodriguesporan.uilists.presentation.view.authentication

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.data.api.GatewayApiUri.GATEWAY_API_PATH_AUTHORIZE
import com.rodriguesporan.uilists.data.api.GatewayApiUri.buildGatewayApiUri
import com.rodriguesporan.uilists.di.factories.viewmodel.LoginViewModelFactory
import com.rodriguesporan.uilists.presentation.model.LoginUiEvent
import com.rodriguesporan.uilists.presentation.model.LoginUiState
import com.rodriguesporan.uilists.presentation.view.home.HomeActivity

internal class LoginActivity : AppCompatActivity() {

    private val buttonLogin: AppCompatButton by lazy { findViewById(R.id.button_login) }
    private val placeholderContainer: ConstraintLayout by lazy { findViewById(R.id.placeholder_container) }
    private val contentContainer: RelativeLayout by lazy { findViewById(R.id.content_container) }
    private val viewModel: LoginViewModel by viewModels { LoginViewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupListeners()
        collectFlows()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        viewModel.onNewIntentUriReceived(intent?.data)
    }

    private fun setupListeners() {
        buttonLogin.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, buildGatewayApiUri(GATEWAY_API_PATH_AUTHORIZE))
            startActivity(intent)
        }
    }

    private fun collectFlows() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { onLoginUiState(it) }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.uiEvent.collect { onLoginUiEvent(it) }
        }
    }

    private fun onLoginUiState(state: LoginUiState) {
        when (state) {
            LoginUiState.Initial -> {
                placeholderContainer.visibility = View.GONE
                contentContainer.visibility = View.VISIBLE
            }
            LoginUiState.Redirecting -> {
                placeholderContainer.visibility = View.VISIBLE
                contentContainer.visibility = View.GONE
            }
        }
    }

    private fun onLoginUiEvent(event: LoginUiEvent) {
        when (event) {
            LoginUiEvent.OpenTrendingScreen -> {
                val intent = HomeActivity
                    .newIntent(this)
                    .addFlags(FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
                finish()
            }
            LoginUiEvent.OpenErrorScreen -> {
                placeholderContainer.visibility = View.GONE
                contentContainer.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
