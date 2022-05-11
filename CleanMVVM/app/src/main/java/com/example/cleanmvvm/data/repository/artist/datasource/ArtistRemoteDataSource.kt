package com.example.cleanmvvm.data.repository.artist.datasource

import com.example.cleanmvvm.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>

}