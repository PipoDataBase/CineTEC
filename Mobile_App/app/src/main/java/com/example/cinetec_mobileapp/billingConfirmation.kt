package com.example.cinetec_mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class billingConfirmation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billing_confirmation)

        val btnIrACartelera: Button = findViewById(R.id.btnReturnToMovieListing)

        btnIrACartelera.setOnClickListener {
            val goToCartelera: Intent = Intent(this, movieListing:: class.java)
            startActivity(goToCartelera)
        }
    }
}