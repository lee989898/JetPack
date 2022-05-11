package com.example.cleanmvvm.data.repository.tvshow.datasourceimpl

import com.example.cleanmvvm.data.db.TvShowDao
import com.example.cleanmvvm.data.model.tvshow.TvShow
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowLocalDataSource

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {

    override suspend fun getTvShows(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        tvShowDao.saveTvShows(tvShows)
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTvShows()
    }
}