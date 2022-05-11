package com.example.cleanmvvm.data.repository.tvshow.datasource

import com.example.cleanmvvm.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShows(): List<TvShow>

    suspend fun saveTvShows(tvShows: List<TvShow>)

    suspend fun clearAll()

}