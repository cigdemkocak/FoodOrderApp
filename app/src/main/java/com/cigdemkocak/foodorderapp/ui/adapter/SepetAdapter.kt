package com.cigdemkocak.foodorderapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cigdemkocak.foodorderapp.R
import com.cigdemkocak.foodorderapp.data.entity.SepetYemekler
import com.cigdemkocak.foodorderapp.databinding.SepetCardTasarimBinding
import com.cigdemkocak.foodorderapp.ui.fragment.SepetFragmentArgs
import com.cigdemkocak.foodorderapp.ui.fragment.SepetFragmentDirections
import com.cigdemkocak.foodorderapp.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar

class  SepetAdapter(var mContext: Context, var sepetListesi:List<SepetYemekler>, var viewModel: SepetViewModel)
    : RecyclerView.Adapter<SepetAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: SepetCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: SepetCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim: SepetCardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.sepet_card_tasarim ,parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val sepetYemek = sepetListesi.get(position)
        val t = holder.tasarim
        t.sepetYemekNesnesi = sepetYemek

        t.imageViewSil.setOnClickListener{
            viewModel.sepetSil(sepetYemek.sepet_yemek_id,sepetYemek.kullanici_adi)
            Snackbar.make(t.imageViewSil,"${sepetYemek.yemek_adi} sepetten silindi.", Snackbar.LENGTH_SHORT).show()

        }

    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }


}
