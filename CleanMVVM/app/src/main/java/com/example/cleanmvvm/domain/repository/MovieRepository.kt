package com.example.cleanmvvm.domain.repository

import com.example.cleanmvvm.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}