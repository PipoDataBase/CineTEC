package com.example.cinetec_mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class movieListing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_listing)

        val btnComprarTiquetesOppenheimer: Button = findViewById(R.id.btnBuyOppenheimerTickets)

        btnComprarTiquetesOppenheimer.setOnClickListener {
            val selectedMovie: String = "Oppenheimer"
            val selectedDateTime: String = "10/01/2023 6:00 PM"
            val selectedLanguage: String = "DOB"
            val selectedProyectionType: String = "2D"
            val goBillingTicketsInformationScreen: Intent = Intent(this, billingTicketsInformation:: class.java).also {
                it.putExtra("selectedMovie", selectedMovie);
                it.putExtra("selectedDatetime", selectedDateTime);
                it.putExtra("selectedLanguage", selectedLanguage)
                it.putExtra("selectedProyectionType", selectedProyectionType)
                startActivity(it);
            }
        }

        val btnComprarTiquetesSoundOfFreedom: Button = findViewById(R.id.btnBuySoundOfFreedomTickets)

        btnComprarTiquetesSoundOfFreedom.setOnClickListener {
            val selectedMovie: String = "Sound of Freedom"
            val selectedDateTime: String = "11/01/2023 6:00 PM"
            val selectedLanguage: String = "DOB"
            val selectedProyectionType: String = "2D"
            val goBillingTicketsInformationScreen: Intent = Intent(this, billingTicketsInformation:: class.java).also {
                it.putExtra("selectedMovie", selectedMovie);
                it.putExtra("selectedDatetime", selectedDateTime);
                it.putExtra("selectedLanguage", selectedLanguage)
                it.putExtra("selectedProyectionType", selectedProyectionType)
                startActivity(it);
            }
        }

        val btnComprarTiquetesBarbie: Button = findViewById(R.id.btnBuyBarbieTickets)

        btnComprarTiquetesBarbie.setOnClickListener {
            val selectedMovie: String = "Barbie"
            val selectedDateTime: String = "12/01/2023 6:00 PM"
            val selectedLanguage: String = "DOB"
            val selectedProyectionType: String = "2D"
            val goBillingTicketsInformationScreen: Intent = Intent(this, billingTicketsInformation:: class.java).also {
                it.putExtra("selectedMovie", selectedMovie);
                it.putExtra("selectedDatetime", selectedDateTime);
                it.putExtra("selectedLanguage", selectedLanguage)
                it.putExtra("selectedProyectionType", selectedProyectionType)
                startActivity(it);
            }
        }

        val btnComprarTiquetesGranTurismo: Button = findViewById(R.id.btnBuyGranTurismoTickets)

        btnComprarTiquetesGranTurismo.setOnClickListener {
            val selectedMovie: String = "Gran Turismo"
            val selectedDateTime: String = "13/01/2023 6:00 PM"
            val selectedLanguage: String = "DOB"
            val selectedProyectionType: String = "2D"
            val goBillingTicketsInformationScreen: Intent = Intent(this, billingTicketsInformation:: class.java).also{
                it.putExtra("selectedMovie", selectedMovie);
                it.putExtra("selectedDatetime", selectedDateTime);
                it.putExtra("selectedLanguage", selectedLanguage)
                it.putExtra("selectedProyectionType", selectedProyectionType)
                startActivity(it);
            }
        }
    }
}