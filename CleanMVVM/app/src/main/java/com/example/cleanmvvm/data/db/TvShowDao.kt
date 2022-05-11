package com.example.cleanmvvm.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanmvvm.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows : List<TvShow>)

    @Query("DELETE FROM popular_tvShow")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvShow")
    suspend fun getTvShows(): List<TvShow>
}