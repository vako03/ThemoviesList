package com.benten.themovieslist.apis

import com.benten.themovieslist.models.GetPopularsResponse
import com.benten.themovieslist.models.MovieDetailsResponse
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.ZoneId

interface MoviesApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        apiKey:String
    ):GetPopularsResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id")
        id: Int,
        @Query("api_key")
        apiKey: String
    ):MovieDetailsResponse
}