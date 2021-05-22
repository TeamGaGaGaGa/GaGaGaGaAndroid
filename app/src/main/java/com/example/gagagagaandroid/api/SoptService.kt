package com.example.gagagagaandroid.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("friends")
    fun postAddFriend(
        @Body body: RequestFriendData
    ): Call<ResponseFriendData>
}