package kr.puze.highthon.Server

import kr.puze.highthon.Data.UserModel
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @GET("/api/V1/facebook/redirect")
    fun user_facebook(@Query("id") id: String): Call<UserModel>

    @GET("/api/V1/google/redirect")
    fun user_register(@Query("token") host_id: String): Call<UserModel>
}