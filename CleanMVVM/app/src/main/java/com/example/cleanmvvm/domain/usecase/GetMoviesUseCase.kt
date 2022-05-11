package com.example.cleanmvvm.domain.usecase

import com.example.cleanmvvm.data.model.movie.Movie
import com.example.cleanmvvm.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()

}