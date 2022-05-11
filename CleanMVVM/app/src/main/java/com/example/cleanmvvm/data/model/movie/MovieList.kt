package com.example.cleanmvvm.data.model.movie
import com.example.cleanmvvm.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)