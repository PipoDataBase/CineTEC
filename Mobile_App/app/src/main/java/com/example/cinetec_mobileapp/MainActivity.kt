package com.example.cinetec_mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnVerCartelera: Button = findViewById(R.id.btnVerCartelera)

        btnVerCartelera.setOnClickListener {
            val goToMovieListingScreen: Intent = Intent(this, movieListing:: class.java)
            startActivity(goToMovieListingScreen)
        }

        val spnLocations: Spinner = findViewById(R.id.spnUbicacion)

        val locationsOptions = arrayOf("Cartago", "Perez Zeledon", "San Carlos")

        spnLocations.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, locationsOptions)

        val spnBranchOffices: Spinner = findViewById(R.id.spnSucursal)

        val branchOfficesOptions = arrayOf("Paseo metropoli", "San Isidro", "La Fortuna")

        spnBranchOffices.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branchOfficesOptions)

    }
}