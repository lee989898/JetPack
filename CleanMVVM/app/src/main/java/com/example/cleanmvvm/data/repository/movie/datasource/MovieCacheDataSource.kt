package com.example.cleanmvvm.data.repository.movie.datasource

import com.example.cleanmvvm.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun saveMoviesToCache(movies: List<Movie>)

    suspend fun getMoviesFromCache(): List<Movie>

}