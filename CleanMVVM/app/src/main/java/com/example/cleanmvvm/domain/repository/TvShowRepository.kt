package com.example.cleanmvvm.domain.repository

import com.example.cleanmvvm.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>

    suspend fun updateTvShows(): List<TvShow>

}