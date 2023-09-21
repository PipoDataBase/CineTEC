package com.example.cinetec_mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerCartelera: Button = findViewById(R.id.btnVerCartelera)

        btnVerCartelera.setOnClickListener {
            val goToMovieListingScreen: Intent = Intent(this, movieListing:: class.java)
            startActivity(goToMovieListingScreen)
        }
    }
}