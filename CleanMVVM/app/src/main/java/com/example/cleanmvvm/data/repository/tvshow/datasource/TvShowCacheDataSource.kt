package com.example.cleanmvvm.data.repository.tvshow.datasource

import com.example.cleanmvvm.data.model.movie.Movie
import com.example.cleanmvvm.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowFromCache(): List<TvShow>

    suspend fun saveTvShowToCache(tvShows: List<TvShow>)
}