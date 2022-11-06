package com.cigdemkocak.foodorderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.cigdemkocak.foodorderapp.databinding.ActivityAnaBinding
import com.cigdemkocak.foodorderapp.databinding.ActivityGirisYapBinding
import com.cigdemkocak.foodorderapp.ui.viewmodel.AnasayfaViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityAnaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityAnaBinding.inflate(layoutInflater)
        setContentView(tasarim.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        NavigationUI.setupWithNavController(tasarim.bottomNav,navHostFragment.navController)

        /*

        tasarim.imageView3.setOnClickListener
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@AnaActivity,GirisYapActivity::class.java))
        }
        */



    }

}