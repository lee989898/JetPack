package com.example.cleanmvvm.domain.repository

import com.example.cleanmvvm.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}