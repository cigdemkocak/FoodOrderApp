package com.cigdemkocak.foodorderapp.ui.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cigdemkocak.foodorderapp.R
import com.cigdemkocak.foodorderapp.data.entity.Yemekler
import com.cigdemkocak.foodorderapp.databinding.CardTasarimBinding
import com.cigdemkocak.foodorderapp.ui.fragment.AnasayfaFragmentDirections
import com.cigdemkocak.foodorderapp.ui.viewmodel.AnasayfaViewModel


class  YemeklerAdapter(var mContext:Context,var yemeklerListesi:List<Yemekler>,var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim ,parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim
        t.yemekNesnesi = yemek

        t.caradViewYemek.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yemekDetayGecis(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)

        }
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }

}
