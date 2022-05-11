package com.example.cleanmvvm.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.cleanmvvm.data.model.movie.Movie
import com.example.cleanmvvm.domain.usecase.GetMoviesUseCase
import com.example.cleanmvvm.domain.usecase.UpdateMovieUseCase
import kotlinx.coroutines.Dispatchers

class MovieViewModel(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
): ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }


}