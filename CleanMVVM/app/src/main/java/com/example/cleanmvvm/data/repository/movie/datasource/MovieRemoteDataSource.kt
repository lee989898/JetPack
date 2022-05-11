package com.example.cleanmvvm.data.repository.movie.datasource

import com.example.cleanmvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}