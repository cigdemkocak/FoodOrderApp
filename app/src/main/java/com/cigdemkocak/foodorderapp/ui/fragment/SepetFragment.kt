package com.cigdemkocak.foodorderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import com.cigdemkocak.foodorderapp.R
import com.cigdemkocak.foodorderapp.data.entity.SepetYemekler
import com.cigdemkocak.foodorderapp.databinding.FragmentSepetBinding
import com.cigdemkocak.foodorderapp.ui.adapter.SepetAdapter
import com.cigdemkocak.foodorderapp.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_sepet.*

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var tasarim: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_sepet, container, false)
        tasarim.sepetFragment = this

        viewModel.sepetListesi.observe(viewLifecycleOwner){
            val adapter = SepetAdapter(requireContext(),it,viewModel)
            tasarim.sepetAdapter = adapter
            var toplam = 0
            for(sepetYemekler in it){
                toplam = toplam + sepetYemekler.yemek_siparis_adet * sepetYemekler.yemek_fiyat
            }
            tasarim.sepetToplam = toplam.toString()

        }

        tasarim.buttonSepetiOnayla.setOnClickListener {
            Snackbar.make(it,"Sepetiniz Onaylandı",Snackbar.LENGTH_SHORT).show()
        }
        tasarim.switch1.setOnCheckedChangeListener { v, b ->
            if(b){
                Snackbar.make(switch1,"Seçiminiz sepete eklendi",Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(switch1,"Seçiminiz kaldırıldı",Snackbar.LENGTH_SHORT).show()
            }
        }


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepetiYukle("cigdem_kocak")
    }









}

