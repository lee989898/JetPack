package com.example.cleanmvvm.presentation.di.core

import com.example.cleanmvvm.data.db.ArtistDao
import com.example.cleanmvvm.data.db.MovieDao
import com.example.cleanmvvm.data.db.TvShowDao
import com.example.cleanmvvm.data.model.tvshow.TvShow
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cleanmvvm.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.cleanmvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanmvvm.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.cleanmvvm.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}