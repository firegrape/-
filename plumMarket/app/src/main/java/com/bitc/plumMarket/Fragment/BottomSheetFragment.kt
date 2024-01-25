package com.bitc.plumMarket.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.bitc.plumMarket.RetrofitBuilder
import com.bitc.plumMarket.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BottomSheetFragment(
    private val idx: String,
    val tvSellReservation: TextView,
    private val sellCompleteListener: OnSellCompleteListener
) : BottomSheetDialogFragment() {

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

        binding.tvSellReservation.setOnClickListener {
            tvSellReservation.visibility = View.VISIBLE
            dismiss()
        }

        binding.tvSellComplete.setOnClickListener {
            RetrofitBuilder.api.updateSellComplete(idx).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(requireContext(), "거래가 완료되었습니다", Toast.LENGTH_SHORT).show()
                        dismiss()
                        // SellOngoingFragment 리로딩을 위해 콜백 호출
                        sellCompleteListener.onSellComplete()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
        }

        binding.tvSellEdit.setOnClickListener {
            dismiss()
        }

        binding.tvSellHide.setOnClickListener {
            RetrofitBuilder.api.updateSellHide(idx).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(requireContext(), "목록이 숨겨졌습니다", Toast.LENGTH_SHORT).show()
                        dismiss()
                        sellCompleteListener.onSellComplete()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
        }

        binding.tvSellDelete.setOnClickListener {
            RetrofitBuilder.api.updateSellDelete(idx).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        dismiss()
                        sellCompleteListener.onSellComplete()
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Log.d("error", t.localizedMessage)
                }
            })
        }
    }
}