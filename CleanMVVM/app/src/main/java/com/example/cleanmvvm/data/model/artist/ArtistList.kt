package com.example.cleanmvvm.data.model.artist
import com.example.cleanmvvm.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>
)