package com.responsi.usmannurkhakim.dataTarget

import com.google.gson.annotations.SerializedName

//memanggil data key provinsi, penulisan harus sama (case sensitive)
//pada kotlin penamaan variabel menggunakan huruf kecil, untuk mengambil data yang berawalan huruf besar maka menggunakan method SerializedName
data class Province (
    @SerializedName("Kode_Provi")
    val code: Int,
    @SerializedName("Provinsi")
    val prv: String,
    @SerializedName("Kasus_Posi")
    val pst: Int,
    @SerializedName("Kasus_Semb")
    val smb: Int,
    @SerializedName("Kasus_Meni")
    val mgl: Int,
)