package com.example.cleanmvvm.data.repository.artist

import android.util.Log
import com.example.cleanmvvm.data.model.artist.Artist
import com.example.cleanmvvm.data.model.movie.Movie
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistsCacheDataSource
import com.example.cleanmvvm.data.repository.movie.datasource.MovieCacheDataSource
import com.example.cleanmvvm.data.repository.movie.datasource.MovieLocalDataSource
import com.example.cleanmvvm.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.cleanmvvm.domain.repository.ArtistRepository
import com.example.cleanmvvm.domain.repository.MovieRepository
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistsCacheDataSource: ArtistsCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistsCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistsCacheDataSource.getArtistsFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistsCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }


}