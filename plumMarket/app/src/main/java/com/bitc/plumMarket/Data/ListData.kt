package com.bitc.plumMarket.Data

import com.google.gson.annotations.SerializedName

data class ListData(

    val list_idx: Int,
    val list_title: String,
    val list_content: String,
    val list_user_nick: String,
    val list_create_date: String,
    val list_completed_yn: String,
    val list_cate: String,
    val list_loc: String,
    val list_money: Int

)
