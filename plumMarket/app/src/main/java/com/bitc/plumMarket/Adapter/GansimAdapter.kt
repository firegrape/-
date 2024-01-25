package com.bitc.plumMarket.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.plumMarket.Data.GansimData
import com.bitc.plumMarket.ViewHolder.GansimViewHolder
import com.bitc.plumMarket.databinding.GansimItemBinding

class GansimAdapter(val gansimListItem: MutableList<GansimData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GansimViewHolder(
            GansimItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return gansimListItem.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val bind = (holder as GansimViewHolder).binding

        bind.gansimTitle.text = "${gansimListItem[position].favTitle}"
        bind.gansimMoney.text = "${gansimListItem[position].fav_money}"


    }

}