package com.bitc.plumMarket.Adapter



import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.plumMarket.Activity.SangsePageActivity
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.RetrofitBuilder
import com.bitc.plumMarket.ViewHolder.ListViewHolder
import com.bitc.plumMarket.databinding.ListItemBinding
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

    val fileName = items[position].list_image_name

    val storage = FirebaseStorage.getInstance()
    val storageReference = storage.getReference("image")
    Log.d("image33",fileName)

    if (fileName.equals("22") or fileName.equals(null)) {
      Log.d("image", "데이터 없음")


    } else {
      val pathReference = storageReference.child(fileName)
      pathReference.downloadUrl.addOnSuccessListener { uri ->
        Glide.with(holder.itemView.context).load(uri).into(bind.tvListImage);
      }.addOnFailureListener {
        Log.d("image1", "가져오기 실패")
      }


    }

    bind.tvListTitle.setOnClickListener() {
      val selectedIdx = items[position].list_idx

      // SangsePageActivity로 이동하면서 선택된 아이템의 list_idx 값을 전달
      val intent = Intent(holder.itemView.context, SangsePageActivity::class.java)
      intent.putExtra("selected_idx", selectedIdx)

      RetrofitBuilder.api.CountHint(selectedIdx.toString()).enqueue(object: Callback<Void> {
        override fun onResponse(call: Call<Void>, response: Response<Void>) {


        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
          Log.d("error", t.localizedMessage)


        }
      })
      holder.itemView.context.startActivity(intent)
    }
  }
}










