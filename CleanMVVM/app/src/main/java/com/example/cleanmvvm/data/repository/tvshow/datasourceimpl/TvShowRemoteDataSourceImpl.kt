package com.example.cleanmvvm.data.repository.tvshow.datasourceimpl

import com.example.cleanmvvm.data.api.TMDBService
import com.example.cleanmvvm.data.db.TvShowDao
import com.example.cleanmvvm.data.model.tvshow.TvShowList
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String): TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}