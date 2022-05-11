package com.example.cleanmvvm.data.repository.artist.datasource

import com.example.cleanmvvm.data.model.artist.Artist
import com.example.cleanmvvm.data.model.movie.Movie

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDB(movies: List<Artist>)

    suspend fun clearAll()
}