package com.example.cleanmvvm.presentation.di.artist

import com.example.cleanmvvm.domain.usecase.GetArtistsUseCase
import com.example.cleanmvvm.domain.usecase.UpdateArtistsUseCase
import com.example.cleanmvvm.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase, updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase, updateArtistsUseCase
        )
    }

}