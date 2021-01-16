package com.responsi.usmannurkhakim.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.responsi.usmannurkhakim.R
import com.responsi.usmannurkhakim.api_corona.RetrofitObject
import com.responsi.usmannurkhakim.dataTarget.IndonesiaData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getIndonesiaData()

        val btn: Button = findViewById(R.id.tombolProvinsi)
        btn.setOnClickListener {
            Intent(this@MainActivity, SecondActivity::class.java).also{
                startActivity(it)
            }
        }
    }

    //fungsi untuk menampilkan data pada objek indonesia
    private fun getIndonesiaData() {
        var pgBar: ProgressBar = findViewById(R.id.progressBar)
        pgBar.visibility = View.VISIBLE
        RetrofitObject.ptn.dataIndonesia().enqueue(object :
                Callback<ArrayList<IndonesiaData>> {

            //menampung arraylist (data) yang akan ditampilkan
            override fun onResponse(
                    call: Call<ArrayList<IndonesiaData>>,
                    response: Response<ArrayList<IndonesiaData>>
            ) {
                pgBar.visibility = View.GONE
                val indonesia = response.body()?.get(0)
                val posit = indonesia?.positif
                val rawat = indonesia?.dirawat
                val sembuh = indonesia?.sembuh
                val meninggal = indonesia?.meninggal

                //menentukan id pada xml untuk menampilkan data
                val am_positive:TextView = findViewById(R.id.txt_positif)
                am_positive.text = posit
                val am_rawat:TextView = findViewById(R.id.txt_dirawat)
                am_rawat.text = rawat
                val am_sembuh:TextView = findViewById(R.id.txt_sembuh)
                am_sembuh.text = sembuh
                val am_meninggal: TextView = findViewById(R.id.txt_meninggal)
                am_meninggal.text = meninggal
            }

            //untuk menampilkan pesan jika terjadi error
            override fun onFailure(call: Call<ArrayList<IndonesiaData>>, t: Throwable) {
                pgBar.visibility = View.GONE
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}