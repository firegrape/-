package com.bitc.plumMarket.Adapter



import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.plumMarket.Activity.SangsePageActivity
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.ViewHolder.ListViewHolder
import com.bitc.plumMarket.databinding.ListItemBinding


class ListAdapter(val items: MutableList<ListData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return ListViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val bind = (holder as ListViewHolder).binding
    bind.tvListIdx.text = items[position].list_idx.toString()
    bind.tvListTitle.text = items[position].list_title
    bind.tvListMoney.text = items[position].list_money.toString() + "원"

    bind.tvListTitle.setOnClickListener() {
      val selectedIdx = items[position].list_idx

      // SangsePageActivity로 이동하면서 선택된 아이템의 list_idx 값을 전달
      val intent = Intent(holder.itemView.context, SangsePageActivity::class.java)
      intent.putExtra("selected_idx", selectedIdx)
      holder.itemView.context.startActivity(intent)
    }
  }
}










