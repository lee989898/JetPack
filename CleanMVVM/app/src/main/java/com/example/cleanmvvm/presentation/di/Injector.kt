package com.example.cleanmvvm.presentation.di

import com.example.cleanmvvm.presentation.di.artist.ArtistSubComponent
import com.example.cleanmvvm.presentation.di.movie.MovieSubComponent
import com.example.cleanmvvm.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent

}