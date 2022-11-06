package com.cigdemkocak.foodorderapp.data.datasource

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.cigdemkocak.foodorderapp.R
import com.cigdemkocak.foodorderapp.data.entity.SepetYemekler
import com.cigdemkocak.foodorderapp.data.entity.Yemekler
import com.cigdemkocak.foodorderapp.retrofit.YemeklerDao
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var ydao: YemeklerDao) {
    val yemeklerListesi = MutableLiveData<List<Yemekler>>()

    suspend fun yemekleriYukle() :List<Yemekler> =
        withContext(Dispatchers.IO){
            ydao.yemekleriYukle().yemekler
        }

    suspend fun sepeteYemekEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String) =
        withContext(Dispatchers.IO){
            ydao.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
            Log.e("Sonuc", "$yemek_adi, $yemek_resim_adi, $yemek_fiyat , $yemek_siparis_adet, $kullanici_adi")
        }
        

    suspend fun sepetiYukle(kullanici_adi: String) : List<SepetYemekler> =
        withContext(Dispatchers.IO){
            ydao.sepetiYukle(kullanici_adi).sepet_yemekler
        }


    suspend fun yemekSil(sepet_yemek_id:Int, kullanici_adi: String) = ydao.yemekSil(sepet_yemek_id, kullanici_adi)

    suspend fun adetArttir(adetSayisi: String) : String =
        withContext(Dispatchers.IO){
            val adet = adetSayisi.toInt()
            val sonuc = adet + 1
            return@withContext sonuc.toString()
        }


    suspend fun adetAzalt(adetSayisi: String) : String=
        withContext(Dispatchers.IO){
            val adet = adetSayisi.toInt()
            val sonuc = adet - 1
            return@withContext sonuc.toString()
        }


    suspend fun ara(aramaKelimesi: String) : MutableLiveData<List<Yemekler>>{

        return yemeklerListesi
    }





}