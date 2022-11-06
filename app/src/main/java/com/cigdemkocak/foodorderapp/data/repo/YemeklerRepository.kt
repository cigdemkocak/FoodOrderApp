package com.cigdemkocak.foodorderapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.cigdemkocak.foodorderapp.data.datasource.YemeklerDataSource
import com.cigdemkocak.foodorderapp.data.entity.SepetYemekler
import com.cigdemkocak.foodorderapp.data.entity.Yemekler

class YemeklerRepository(var yds:YemeklerDataSource) {
    suspend fun yemekleriYukle() :List<Yemekler> = yds.yemekleriYukle()

    suspend fun sepeteYemekEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String) =
        yds.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

    suspend fun sepetiYukle(kullanici_adi: String) : List<SepetYemekler> = yds.sepetiYukle(kullanici_adi)

    suspend fun yemekSil(sepet_yemek_id:Int , kullanici_adi: String)  = yds.yemekSil(sepet_yemek_id, kullanici_adi)

    suspend fun adetArttir(adetSayisi: String) : String = yds.adetArttir(adetSayisi)

    suspend fun adetAzalt(adetSayisi: String) : String = yds.adetAzalt(adetSayisi)

    suspend fun ara(aramaKelimesi:String) : MutableLiveData<List<Yemekler>> = yds.ara(aramaKelimesi)
}