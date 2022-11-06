package com.cigdemkocak.foodorderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.cigdemkocak.foodorderapp.databinding.ActivityHesapOlusturBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class HesapOlusturActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityHesapOlusturBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityHesapOlusturBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        firebaseAuth = FirebaseAuth.getInstance()

        tasarim.textView6.setOnClickListener{
            val intent = Intent(this,GirisYapActivity::class.java)
            startActivity(intent)
        }

        tasarim.buttonHesapOlustur.setOnClickListener{
            val email = tasarim.emailEt.text.toString()
            val sifre = tasarim.sifreEt.text.toString()
            val tekrarSifre = tasarim.tekrarSifreEt.text.toString()

            if(email.isNotEmpty() && sifre.isNotEmpty() && tekrarSifre.isNotEmpty() ){
                if(sifre == tekrarSifre){
                    firebaseAuth.createUserWithEmailAndPassword(email,sifre).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intent = Intent(this, GirisYapActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this,"Şifreler eşleşmiyor",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Boş alan bırakılamaz",Toast.LENGTH_SHORT).show()
            }

        }


    }
}