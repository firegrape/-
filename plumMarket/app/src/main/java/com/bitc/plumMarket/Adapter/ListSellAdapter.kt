package com.bitc.plumMarket.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.Fragment.BottomSheetFragment
import com.bitc.plumMarket.Fragment.OnSellCompleteListener
import com.bitc.plumMarket.ViewHolder.ListSellViewHolder
import com.bitc.plumMarket.databinding.ListSellItemBinding


class ListSellAdapter(
  private var items: MutableList<ListData>,
  private val activity: AppCompatActivity,
  private val recyclerView: RecyclerView,
  private val sellCompleteListener: OnSellCompleteListener
) : RecyclerView.Adapter<ListSellViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSellViewHolder {
    val binding = ListSellItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ListSellViewHolder(binding)
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(holder: ListSellViewHolder, position: Int) {
    val bind = holder.binding
    val idx = items[position].list_idx.toString()
    bind.tvListSellIdx.text = items[position].list_idx.toString()
    bind.tvListSellTitle.text = items[position].list_title
    bind.tvListSellMoney.text = "${items[position].list_money}원"

    bind.btnEtc.setOnClickListener {
      val bottomSheetFragment = BottomSheetFragment(idx, bind.tvSellReservation,sellCompleteListener)
      bottomSheetFragment.show(activity.supportFragmentManager, bottomSheetFragment.tag)
    }
  }

  fun setItems(newItems: List<ListData>) {
    items = newItems.toMutableList()
    notifyDataSetChanged()
    recyclerView.requestLayout()
  }
}
