package com.example.permissionrequestexample.view.room

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.permissionrequestexample.R

class HumanAdapter: RecyclerView.Adapter<HumanAdapter.HumanViewHolder>() {

    var humanEntityList = listOf<HumanEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun fillData(humanEntities: List<HumanEntity>) {
        this.humanEntityList = humanEntities
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HumanViewHolder(layoutInflater.inflate(R.layout.item_human, parent, false))
    }

    override fun onBindViewHolder(holder: HumanViewHolder, position: Int) {
        val item = humanEntityList[position]
        with(holder){
            tvName.text = item.name
            tvLastName.text = item.lastName
        }
    }

    override fun getItemCount(): Int = humanEntityList.size

    inner class HumanViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById<TextView>(R.id.tv_name)
        val tvLastName: TextView = view.findViewById<TextView>(R.id.tv_lastname)
    }
}