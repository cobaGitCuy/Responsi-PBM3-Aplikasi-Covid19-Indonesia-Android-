package com.responsi.usmannurkhakim.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.responsi.usmannurkhakim.R
import com.responsi.usmannurkhakim.adapter.RecyclerAdapter
import com.responsi.usmannurkhakim.api_corona.RetrofitObject
import com.responsi.usmannurkhakim.dataTarget.ProvData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getProvinceData()
    }

    // fungsi untuk menampilkan data provinsi
    private fun getProvinceData() {
        var pgBar2: ProgressBar = findViewById(R.id.progressBar2) //icon loading
        pgBar2.visibility = View.VISIBLE //set visible sebelum data ditampilkan

        val rvp:RecyclerView = findViewById(R.id.recycleViewProvinsi)
        rvp.setHasFixedSize(true)
        rvp.layoutManager = LinearLayoutManager(this)

        RetrofitObject.ptn.dataProv().enqueue(object : Callback<ArrayList<ProvData>> {
            override fun onResponse(call: Call<ArrayList<ProvData>>, response: Response<ArrayList<ProvData>>) {
                pgBar2.visibility = View.GONE
                val list = response.body()
                val adapter = list?.let{ RecyclerAdapter(it) }
                rvp.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvData>>, t: Throwable) {
                pgBar2.visibility = View.GONE
                Toast.makeText(this@SecondActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}