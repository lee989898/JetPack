package com.example.cleanmvvm.data.repository.tvshow

import android.util.Log
import com.example.cleanmvvm.data.model.artist.Artist
import com.example.cleanmvvm.data.model.movie.Movie
import com.example.cleanmvvm.data.model.tvshow.TvShow
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.cleanmvvm.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.cleanmvvm.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {

    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShows(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShows()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShows(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow>{
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }

}