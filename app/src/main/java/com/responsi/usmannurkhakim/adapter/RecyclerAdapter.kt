package com.responsi.usmannurkhakim.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.responsi.usmannurkhakim.R
import com.responsi.usmannurkhakim.dataTarget.ProvData

class RecyclerAdapter (private var lst: ArrayList<ProvData>) : RecyclerView.Adapter<RecyclerAdapter.Pvholder> () {
    inner class Pvholder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(provinsi: ProvData) {
            with(itemView) {
                val provTitle: TextView = findViewById(R.id.provinceTitle)
                provTitle.text = provinsi.attributes.prv
                val provPositif: TextView = findViewById(R.id.provincePositif)
                provPositif.text = provinsi.attributes.pst.toString()
                val provSembuh: TextView = findViewById(R.id.provinceSembuh)
                provSembuh.text = provinsi.attributes.smb.toString()
                val provMeninggal: TextView = findViewById(R.id.provinceMeninggal)
                provMeninggal.text = provinsi.attributes.mgl.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pvholder {
        val show = LayoutInflater.from(parent.context).inflate(R.layout.statistik_provinsi, parent, false)
        return Pvholder(show)
    }

    override fun onBindViewHolder(holder: Pvholder, position: Int) {
        holder.bind(lst[position])
    }

    override fun getItemCount(): Int = lst.size
}