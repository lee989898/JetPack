package com.example.cleanmvvm.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanmvvm.domain.usecase.GetTvShowUseCase
import com.example.cleanmvvm.domain.usecase.UpdateTvShowUseCase
import com.example.cleanmvvm.presentation.movie.MovieViewModel

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase,updateTvShowUseCase)  as T
    }
}