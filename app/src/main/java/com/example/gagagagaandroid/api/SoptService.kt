package com.example.gagagagaandroid.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SoptService {
    @POST("friends")
    fun postAddFriend(
        @Body body: RequestFriendData
    ): Call<ResponseFriendData>

    @GET("friends/:{id}")
    fun postFriendLookUp(@Path("id") id: String): Call<ResponseFriendLookData>
}