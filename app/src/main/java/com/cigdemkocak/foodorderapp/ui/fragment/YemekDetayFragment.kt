package com.cigdemkocak.foodorderapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.cigdemkocak.foodorderapp.R
import com.cigdemkocak.foodorderapp.databinding.FragmentYemekDetayBinding
import com.cigdemkocak.foodorderapp.ui.viewmodel.YemekDetayViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_sepet.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class YemekDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentYemekDetayBinding
    private lateinit var viewModel: YemekDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false)
        tasarim.yemekDetayFragment = this

        val bundle:YemekDetayFragmentArgs by navArgs()
        val gelenYemek = bundle.yemek

        tasarim.yemekNesnesi = gelenYemek

        viewModel.sonuc.observe(viewLifecycleOwner){

            tasarim.adetSayisi = it
        }
        tasarim.kullaniciAdi = "cigdem_kocak"



        return tasarim.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YemekDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSepeteYemekEkle(yemek_adi:String,yemek_resim_adi:String,yemek_fiyat:Int,yemek_siparis_adet:Int,kullanici_adi:String){
        if(yemek_siparis_adet == 0){
            Snackbar.make(tasarim.button4,"Adet Seçiniz", Snackbar.LENGTH_SHORT).show()
        }else{
            viewModel.sepeteYemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

        }

    }

    fun buttonArtiTikla(adetSayisi:String){
        viewModel.adetArttir(adetSayisi)

    }

    fun buttonEksiTikla(adetSayisi:String){
        viewModel.adetAzalt(adetSayisi)
    }

}