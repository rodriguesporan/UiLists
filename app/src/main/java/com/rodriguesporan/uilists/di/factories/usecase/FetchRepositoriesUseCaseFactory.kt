package com.rodriguesporan.uilists.di.factories.usecase

import com.rodriguesporan.uilists.di.factories.repository.RepositoryFactory
import com.rodriguesporan.uilists.domain.repository.RepositoriesRepository
import com.rodriguesporan.uilists.domain.usecase.FetchRepositoriesUseCase

internal class FetchRepositoriesUseCaseFactory(
    private val repositoryFactory: RepositoryFactory<RepositoriesRepository>
): UseCaseFactory<FetchRepositoriesUseCase>() {
    override fun create(): FetchRepositoriesUseCase {
        return FetchRepositoriesUseCase(repositoryFactory.create())
    }
}
