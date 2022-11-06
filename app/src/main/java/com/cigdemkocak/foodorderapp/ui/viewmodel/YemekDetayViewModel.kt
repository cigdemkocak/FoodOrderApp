package com.cigdemkocak.foodorderapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cigdemkocak.foodorderapp.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YemekDetayViewModel @Inject constructor(var yrepo: YemeklerRepository): ViewModel(){
    var sonuc = MutableLiveData("0")

    fun sepeteYemekEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String) {
        CoroutineScope(Dispatchers.IO).launch {
            yrepo.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        }
    }

    fun adetArttir(adetSayisi:String){
        CoroutineScope(Dispatchers.Main).launch{
            sonuc.value = yrepo.adetArttir(adetSayisi)
        }
    }

    fun adetAzalt(adetSayisi:String){
        CoroutineScope(Dispatchers.Main).launch{
            sonuc.value = yrepo.adetAzalt(adetSayisi)
        }
    }



}