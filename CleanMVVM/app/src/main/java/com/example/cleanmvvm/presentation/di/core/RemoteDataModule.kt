package com.example.cleanmvvm.presentation.di.core

import com.example.cleanmvvm.data.api.TMDBService
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cleanmvvm.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.cleanmvvm.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cleanmvvm.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.cleanmvvm.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSoruce(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSoruce(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSoruce(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

}