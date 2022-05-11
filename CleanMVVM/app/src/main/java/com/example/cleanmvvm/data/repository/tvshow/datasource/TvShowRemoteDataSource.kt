package com.example.cleanmvvm.data.repository.tvshow.datasource

import com.example.cleanmvvm.data.db.TvShowDao
import com.example.cleanmvvm.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>

}