package com.rodriguesporan.uilists.presentation.view.authentication

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodriguesporan.uilists.data.model.GitHubUserTokenDTO
import com.rodriguesporan.uilists.data.model.UserTokenRequestParams
import com.rodriguesporan.uilists.di.session.SessionProvider
import com.rodriguesporan.uilists.domain.usecase.FetchGitHubUserTokenUseCase
import com.rodriguesporan.uilists.presentation.model.LoginUiEvent
import com.rodriguesporan.uilists.presentation.model.LoginUiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

internal class LoginViewModel(
    private val fetchGitHubUserTokenUseCase: FetchGitHubUserTokenUseCase,
    private val session: SessionProvider
) : ViewModel() {

    private val _uiEvent = MutableSharedFlow<LoginUiEvent>()
    val uiEvent: SharedFlow<LoginUiEvent> = _uiEvent.asSharedFlow()

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    val uiState: SharedFlow<LoginUiState> = _uiState.asSharedFlow()

    fun onNewIntentUriReceived(uri: Uri?) {
        viewModelScope.launch {
            _uiState.emit(LoginUiState.Redirecting)
        }
        val gitHubIdentityCode = uri?.getQueryParameter("code")
        if (gitHubIdentityCode?.isNotBlank() == true) {
            fetchUserToken(gitHubIdentityCode)
        }
    }

    private fun fetchUserToken(gitHubIdentityCode: String) {
        val request = UserTokenRequestParams(code = gitHubIdentityCode)
        viewModelScope.launch {
            try {
                val response: GitHubUserTokenDTO = fetchGitHubUserTokenUseCase(request)
                session.saveAccessToken(response.accessToken)
                _uiEvent.emit(LoginUiEvent.OpenTrendingScreen)
            } catch (e: Exception) {
                _uiEvent.emit(LoginUiEvent.OpenErrorScreen)
            }
        }
    }
}
