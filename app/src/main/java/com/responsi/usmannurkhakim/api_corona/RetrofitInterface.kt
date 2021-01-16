package com.responsi.usmannurkhakim.api_corona

import com.responsi.usmannurkhakim.dataTarget.IndonesiaData
import com.responsi.usmannurkhakim.dataTarget.ProvData
import retrofit2.Call
import retrofit2.http.GET

//memanggil data Indonesia dan Provinsi menggunakan retrofit dengan method GET
interface RetrofitInterface {
    @GET("indonesia")
    fun dataIndonesia(): Call<ArrayList<IndonesiaData>>

    @GET("indonesia/provinsi")
    fun dataProv(): Call<ArrayList<ProvData>>
}