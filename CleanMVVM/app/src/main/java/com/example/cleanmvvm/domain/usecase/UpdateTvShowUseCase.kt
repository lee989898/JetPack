package com.example.cleanmvvm.domain.usecase

import com.example.cleanmvvm.data.model.tvshow.TvShow
import com.example.cleanmvvm.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}