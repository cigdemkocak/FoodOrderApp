package com.cigdemkocak.foodorderapp.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("yemek_resim")
fun resimGoster(view: ImageView, resimAdi:String){
    val url = "http://kasimadalan.pe.hu/yemekler/resimler/${resimAdi}"

    Glide.with(view).load(url).override(300,300).into(view)
}