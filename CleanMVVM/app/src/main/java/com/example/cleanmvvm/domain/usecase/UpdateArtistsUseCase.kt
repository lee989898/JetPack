package com.example.cleanmvvm.domain.usecase

import com.example.cleanmvvm.data.model.artist.Artist
import com.example.cleanmvvm.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}