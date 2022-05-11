package com.example.cleanmvvm.data.repository.artist.datasourceimpl

import com.example.cleanmvvm.data.api.TMDBService
import com.example.cleanmvvm.data.model.artist.ArtistList
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String): ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }

}