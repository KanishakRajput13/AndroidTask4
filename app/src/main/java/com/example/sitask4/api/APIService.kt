package com.example.sitask4.api

import com.example.sitask4.api.fields.UserBadges
import com.example.sitask4.api.fields.UserProfile
import com.example.sitask4.api.fields.UserSolved
import com.example.sitask4.api.fields.UserSubmissions
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    //to get the username from API
    @GET("/{username}")
    suspend fun getUserProfile(
        @Path("username") username: String
    ): Response<UserProfile>

    //to get the user badges from API
    @GET("/{username}/badges")
    suspend fun getUserBadges(
        @Path("username") username: String
    ): Response<UserBadges>

    //to get the user solved problems from API
    @GET("/{username}/solved")
    suspend fun getUserSolved(
        @Path("username") username: String
    ): Response<UserSolved>

    //to get the user's limited submissions from API
    @GET("/{username}/submissions")
    suspend fun getUserSubmissions(
        @Path("username") username: String
    ): Response<UserSubmissions>
}