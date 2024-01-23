package com.bitc.plumMarket

import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.Data.LoginData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("/LoginChk")
    fun getPostList(
        @Field("id")id:String, @Field("pw")pw: String): Call<LoginData>

    @FormUrlEncoded
    @POST("/Join")
    fun setJoin(
        @Field("id")id:String,
        @Field("pw")pw: String,
        @Field("pw2")pw2: String,
        @Field("nickname")nickname: String,
        @Field("email")email: String,): Call<Void>

    @GET("/selectList")
    fun getListData(): Call<List<ListData>>

}



object RetrofitBuilder {
    var api: Api = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8080")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()
        .create(Api::class.java)
}