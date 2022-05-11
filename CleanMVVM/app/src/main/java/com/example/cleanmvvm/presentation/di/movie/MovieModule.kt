package com.example.cleanmvvm.presentation.di.movie

import com.example.cleanmvvm.domain.usecase.GetArtistsUseCase
import com.example.cleanmvvm.domain.usecase.GetMoviesUseCase
import com.example.cleanmvvm.domain.usecase.UpdateArtistsUseCase
import com.example.cleanmvvm.domain.usecase.UpdateMovieUseCase
import com.example.cleanmvvm.presentation.artist.ArtistViewModelFactory
import com.example.cleanmvvm.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase, updateMovieUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase, updateMovieUseCase
        )
    }

}