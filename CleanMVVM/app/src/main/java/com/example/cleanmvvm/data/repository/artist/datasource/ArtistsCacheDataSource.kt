package com.example.cleanmvvm.data.repository.artist.datasource

import com.example.cleanmvvm.data.model.artist.Artist
import com.example.cleanmvvm.data.model.movie.Movie

interface ArtistsCacheDataSource {

    suspend fun saveArtistsToCache(artists: List<Artist>)

    suspend fun getArtistsFromCache(): List<Artist>
}