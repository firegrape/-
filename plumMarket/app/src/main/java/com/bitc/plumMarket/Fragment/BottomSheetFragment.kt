package com.bitc.plumMarket.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitc.plumMarket.Adapter.ListAdapter
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.R
import com.bitc.plumMarket.RetrofitBuilder
import com.bitc.plumMarket.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BottomSheetFragment(private val idx: String) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun viewReload(){
            RetrofitBuilder.api.getListData().enqueue(object: Callback<List<ListData>> {
                override fun onResponse(call: Call<List<ListData>>, response: Response<List<ListData>>) {
                    if(response.isSuccessful){
                        val list = response.body()
                        val items = mutableListOf<ListData>()
                        if (list != null) {
                            // listData를 활용하여 필요한 처리를 수행해주세요
                            // 예시: listData를 순회하며 각 객체의 필드를 읽어옴
                            for (data in list) {
                                val title = data.list_title
                                val money = data.list_money
                                val idx = data.list_idx

                                items.add(ListData(idx,title,money))
                                val listAdapter = ListAdapter(items)
                                // 변수에 값을 넣어 사용하거나 처리해주세요
                                // 예시: 로그로 출력

                                val linearLayoutManager = LinearLayoutManager(requireContext())
                                linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

                                // Fragment의 레이아웃에서 리사이클러뷰를 찾아서 설정
                                val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewList)
                                recyclerView.layoutManager = linearLayoutManager
                                recyclerView.adapter = listAdapter
                                recyclerView.addItemDecoration(
                                    DividerItemDecoration(
                                        requireContext(),
                                        LinearLayoutManager.VERTICAL
                                    )
                                )
                            }
                        } else {
                            Log.d("ysh", "listData is null")
                        }
                    }
                }

                override fun onFailure(call: Call<List<ListData>>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
        }

        binding.tvSellReservation.setOnClickListener(){

            RetrofitBuilder.api.updateSellReservation(idx).enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        dismiss()
                        // 다시 BottomSheet 열기
                        val newBottomSheetFragment = BottomSheetFragment(idx)
                        newBottomSheetFragment.show(parentFragmentManager, newBottomSheetFragment.tag)
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
        }

        binding.tvSellComplete.setOnClickListener(){

            RetrofitBuilder.api.updateSellComplete(idx).enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        dismiss()
                        // 다시 BottomSheet 열기
                        viewReload()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
        }

        binding.tvSellEdit.setOnClickListener(){

        }

        binding.tvSellHide.setOnClickListener(){

        }

        binding.tvSellDelete.setOnClickListener(){
            RetrofitBuilder.api.updateSellDelete(idx).enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        dismiss()
                        viewReload()

                        // 새로운 BottomSheetFragment를 생성하여 열기
                        val newBottomSheetFragment = BottomSheetFragment(idx)
                        newBottomSheetFragment.show(parentFragmentManager, newBottomSheetFragment.tag)
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
        }


    }
}
