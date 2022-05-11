package com.example.cleanmvvm.presentation.di.core

import com.example.cleanmvvm.data.repository.artist.ArtistRepositoryImpl
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistsCacheDataSource
import com.example.cleanmvvm.data.repository.movie.MovieRepositoryImpl
import com.example.cleanmvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cleanmvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanmvvm.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cleanmvvm.data.repository.tvshow.TvShowRepositoryImpl
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.cleanmvvm.domain.repository.ArtistRepository
import com.example.cleanmvvm.domain.repository.MovieRepository
import com.example.cleanmvvm.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistsCacheDataSource: ArtistsCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistsCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

}