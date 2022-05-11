package com.example.cleanmvvm.presentation.di.tvshow

import com.example.cleanmvvm.domain.usecase.GetArtistsUseCase
import com.example.cleanmvvm.domain.usecase.GetTvShowUseCase
import com.example.cleanmvvm.domain.usecase.UpdateArtistsUseCase
import com.example.cleanmvvm.domain.usecase.UpdateTvShowUseCase
import com.example.cleanmvvm.presentation.artist.ArtistViewModelFactory
import com.example.cleanmvvm.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowUseCase, updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase, updateTvShowUseCase
        )
    }

}