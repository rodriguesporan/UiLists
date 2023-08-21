package com.rodriguesporan.uilists.di.factories.usecase

import com.rodriguesporan.uilists.di.factories.repository.RepositoryFactory
import com.rodriguesporan.uilists.domain.repository.AuthenticationRepository
import com.rodriguesporan.uilists.domain.usecase.FetchUserTokenUseCase

internal class FetchUserTokenUseCaseFactory(
    private val repositoryFactory: RepositoryFactory<AuthenticationRepository>
): UseCaseFactory<FetchUserTokenUseCase>() {
    override fun create(): FetchUserTokenUseCase {
        return FetchUserTokenUseCase(repositoryFactory.create())
    }
}
