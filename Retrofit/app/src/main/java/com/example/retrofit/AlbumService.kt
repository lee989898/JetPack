package com.example.retrofit

import retrofit2.Response
import retrofit2.http.*
import java.sql.RowId

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId: Int): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId: Int): Response<AlbumItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumItem): Response<AlbumItem>
}