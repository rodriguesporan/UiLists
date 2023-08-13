package com.rodriguesporan.uilists.presentation.model

import com.rodriguesporan.uilists.data.model.GitHubRepositoryDTO

internal sealed class HomeUiState {
    object Error : HomeUiState()
    object Loading : HomeUiState()
    data class Success(
        val repositories: List<GitHubRepositoryDTO>
    ) : HomeUiState()
}
