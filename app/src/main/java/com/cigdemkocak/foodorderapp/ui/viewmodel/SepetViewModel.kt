package com.cigdemkocak.foodorderapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cigdemkocak.foodorderapp.R
import com.cigdemkocak.foodorderapp.data.entity.SepetYemekler
import com.cigdemkocak.foodorderapp.data.repo.YemeklerRepository
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SepetViewModel  @Inject constructor(var yrepo: YemeklerRepository): ViewModel() {
    var sepetListesi = MutableLiveData<List<SepetYemekler>>()

    init {

        sepetiYukle("cigdem_kocak")


    }

    fun sepetiYukle(kullanici_adi : String){
        CoroutineScope(Dispatchers.Main).launch{
            sepetListesi.value = yrepo.sepetiYukle(kullanici_adi)
        }
    }

    fun sepetSil(sepet_yemek_id:Int, kullanici_adi: String){
        CoroutineScope(Dispatchers.Main).launch{
            yrepo.yemekSil(sepet_yemek_id , kullanici_adi)
            sepetiYukle(kullanici_adi)
        }
    }




}