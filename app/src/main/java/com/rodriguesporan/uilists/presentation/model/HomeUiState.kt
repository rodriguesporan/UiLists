package com.rodriguesporan.uilists.presentation.model

import com.rodriguesporan.uilists.data.model.RepositoryDTO

internal sealed class HomeUiState {
    object Error : HomeUiState()
    object Loading : HomeUiState()
    data class Success(
        val repositories: List<RepositoryDTO>
    ) : HomeUiState()
}
