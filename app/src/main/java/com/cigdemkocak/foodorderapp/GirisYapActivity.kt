package com.cigdemkocak.foodorderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cigdemkocak.foodorderapp.databinding.ActivityGirisYapBinding
import com.google.firebase.auth.FirebaseAuth

class GirisYapActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityGirisYapBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityGirisYapBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        firebaseAuth = FirebaseAuth.getInstance()

        tasarim.textView8.setOnClickListener{
            val intent = Intent(this,HesapOlusturActivity::class.java)
            startActivity(intent)
        }

        tasarim.buttonGirisYap.setOnClickListener{
            val emailGiris = tasarim.editTextEmail.text.toString()
            val sifreGiris = tasarim.editTextSifre.text.toString()

            if (emailGiris.isNotEmpty() && sifreGiris.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(emailGiris, sifreGiris).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, AnaActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Boş alan bırakılamaz", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, AnaActivity::class.java)
            startActivity(intent)
        }
    }

}