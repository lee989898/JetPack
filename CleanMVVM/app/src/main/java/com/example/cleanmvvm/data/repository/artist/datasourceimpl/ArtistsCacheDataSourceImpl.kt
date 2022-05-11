package com.example.cleanmvvm.data.repository.artist.datasourceimpl

import com.example.cleanmvvm.data.model.artist.Artist
import com.example.cleanmvvm.data.repository.artist.datasource.ArtistsCacheDataSource


class ArtistsCacheDataSourceImpl : ArtistsCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

}