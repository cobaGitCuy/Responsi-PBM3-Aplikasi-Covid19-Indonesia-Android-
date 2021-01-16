package com.responsi.usmannurkhakim.api_corona

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//untuk menampung URL API
object RetrofitObject {
    private const val BASE_URL = "https://api.kawalcorona.com/"

    //instansiasi menggunakan method lazy karena nilai tidak akan berubah
    val ptn: RetrofitInterface by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(RetrofitInterface::class.java)
    }
}