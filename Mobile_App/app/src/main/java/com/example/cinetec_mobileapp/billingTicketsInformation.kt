package com.example.cinetec_mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TabHost
import android.view.View
import android.widget.EditText

class billingTicketsInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //val selectedMovie = intent.getStringExtra("selectedMovie");
        //val selectedDateTime = intent.getStringExtra("selectedDateTime");
        //val selectedLanguage = intent.getStringExtra("selectedLanguage");
        //val selectedProyectionType = intent.getStringExtra("selectedProyectionType");

        var seatsStatesArray = arrayOf<Int>(0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0);

        var selectedKidsTickets: Int = 0;
        var selectedAdultsTickets: Int = 0;
        var selectedElderlyTickets: Int = 0;
        var selectedSeats: Int = 0;

        var totalSpecifiedSeats: Int = 0;
        /*
        val kidsTickets: EditText = findViewById(R.id.edt_txtNinos)
        val adultsTickets: EditText = findViewById(R.id.edt_txtAdultos)
        val elderlyTickets: EditText = findViewById(R.id.edt_txtAdultosmayores)

        val btnConfTickets: Button = findViewById(R.id.btnConfirmTickets)

        btnConfTickets.setOnClickListener{
            selectedKidsTickets = Integer.parseInt(kidsTickets.text.toString())
            selectedAdultsTickets = Integer.parseInt(adultsTickets.text.toString())
            selectedElderlyTickets = Integer.parseInt(elderlyTickets.text.toString())

            totalSpecifiedSeats = selectedKidsTickets + selectedAdultsTickets + selectedElderlyTickets
        }
        */
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_billing_tickets_information)

        val tabHost = findViewById<TabHost>(R.id.tab_hstBillingTicketsInformation)
        tabHost.setup()

        // Code for adding Tab 1 to the tabhost
        var spec = tabHost.newTabSpec("Tiquetes")
        spec.setContent(R.id.tabTiquetes)

        // setting the name of the tab 1 as "Tab One"
        spec.setIndicator("Tiquetes")

        // adding the tab to tabhost
        tabHost.addTab(spec)

        // Code for adding Tab 2 to the tabhost
        spec = tabHost.newTabSpec("Assientos")
        spec.setContent(R.id.tabAsientos)

        // setting the name of the tab 1 as "Tab Two"
        spec.setIndicator("Assientos")
        tabHost.addTab(spec)

        // Code for adding Tab 3 to the tabhost
        spec = tabHost.newTabSpec("Pago")
        spec.setContent(R.id.tabPago)
        spec.setIndicator("Pago")
        tabHost.addTab(spec)

        val btnseleccionarAsiento1_1: ImageButton = findViewById(R.id.roomSeat1_1)

        btnseleccionarAsiento1_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[0] == 0){
                btnseleccionarAsiento1_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[0] = 1;
            } else if (seatsStatesArray[0] == 1){
                btnseleccionarAsiento1_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[0] = 0;
            }
        }

        val btnseleccionarAsiento1_2: ImageButton = findViewById(R.id.roomSeat1_2)

        btnseleccionarAsiento1_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[1] == 0){
                btnseleccionarAsiento1_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[1] = 1;
            } else if (seatsStatesArray[1] == 1){
                btnseleccionarAsiento1_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[1] = 0;
            }
        }

        val btnseleccionarAsiento1_3: ImageButton = findViewById(R.id.roomSeat1_3)

        btnseleccionarAsiento1_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[2] == 0){
                btnseleccionarAsiento1_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[2] = 1;
            } else if (seatsStatesArray[2] == 1){
                btnseleccionarAsiento1_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[2] = 0;
            }
        }

        val btnseleccionarAsiento1_4: ImageButton = findViewById(R.id.roomSeat1_4)

        btnseleccionarAsiento1_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[3] == 0){
                btnseleccionarAsiento1_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[3] = 1;
            } else if (seatsStatesArray[3] == 1){
                btnseleccionarAsiento1_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[3] = 0;
            }
        }

        val btnseleccionarAsiento1_5: ImageButton = findViewById(R.id.roomSeat1_5)

        btnseleccionarAsiento1_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[4] == 0){
                btnseleccionarAsiento1_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[4] = 1;
            } else if (seatsStatesArray[4] == 1){
                btnseleccionarAsiento1_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[4] = 0;
            }
        }

        val btnseleccionarAsiento1_6: ImageButton = findViewById(R.id.roomSeat1_6)

        btnseleccionarAsiento1_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[5] == 0){
                btnseleccionarAsiento1_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[5] = 1;
            } else if (seatsStatesArray[5] == 1){
                btnseleccionarAsiento1_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[5] = 0;
            }
        }

        val btnseleccionarAsiento1_7: ImageButton = findViewById(R.id.roomSeat1_7)

        btnseleccionarAsiento1_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[6] == 0){
                btnseleccionarAsiento1_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[6] = 1;
            } else if (seatsStatesArray[6] == 1){
                btnseleccionarAsiento1_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[6] = 0;
            }
        }

        val btnseleccionarAsiento1_8: ImageButton = findViewById(R.id.roomSeat1_8)

        btnseleccionarAsiento1_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[7] == 0){
                btnseleccionarAsiento1_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[7] = 1;
            } else if (seatsStatesArray[7] == 1){
                btnseleccionarAsiento1_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[7] = 0;
            }
        }

        val btnseleccionarAsiento1_9: ImageButton = findViewById(R.id.roomSeat1_9)

        btnseleccionarAsiento1_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[8] == 0){
                btnseleccionarAsiento1_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[8] = 1;
            } else if (seatsStatesArray[8] == 1){
                btnseleccionarAsiento1_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[8] = 0;
            }
        }

        val btnseleccionarAsiento1_10: ImageButton = findViewById(R.id.roomSeat1_10)

        btnseleccionarAsiento1_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[9] == 0){
                btnseleccionarAsiento1_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[9] = 1;
            } else if (seatsStatesArray[9] == 1){
                btnseleccionarAsiento1_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[9] = 0;
            }
        }

        //

        val btnseleccionarAsiento2_1: ImageButton = findViewById(R.id.roomSeat2_1)

        btnseleccionarAsiento2_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[10] == 0){
                btnseleccionarAsiento2_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[10] = 1;
            } else if (seatsStatesArray[10] == 1){
                btnseleccionarAsiento2_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[10] = 0;
            }
        }

        val btnseleccionarAsiento2_2: ImageButton = findViewById(R.id.roomSeat2_2)

        btnseleccionarAsiento2_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[11] == 0){
                btnseleccionarAsiento2_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[11] = 1;
            } else if (seatsStatesArray[11] == 1){
                btnseleccionarAsiento2_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[11] = 0;
            }
        }

        val btnseleccionarAsiento2_3: ImageButton = findViewById(R.id.roomSeat2_3)

        btnseleccionarAsiento2_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[12] == 0){
                btnseleccionarAsiento2_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[12] = 1;
            } else if (seatsStatesArray[12] == 1){
                btnseleccionarAsiento2_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[12] = 0;
            }
        }

        val btnseleccionarAsiento2_4: ImageButton = findViewById(R.id.roomSeat2_4)

        btnseleccionarAsiento2_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[13] == 0){
                btnseleccionarAsiento2_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[13] = 1;
            } else if (seatsStatesArray[13] == 1){
                btnseleccionarAsiento2_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[13] = 0;
            }
        }

        val btnseleccionarAsiento2_5: ImageButton = findViewById(R.id.roomSeat2_5)

        btnseleccionarAsiento2_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[14] == 0){
                btnseleccionarAsiento2_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[14] = 1;
            } else if (seatsStatesArray[14] == 1){
                btnseleccionarAsiento2_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[14] = 0;
            }
        }

        val btnseleccionarAsiento2_6: ImageButton = findViewById(R.id.roomSeat2_6)

        btnseleccionarAsiento2_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[15] == 0){
                btnseleccionarAsiento2_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[15] = 1;
            } else if (seatsStatesArray[15] == 1){
                btnseleccionarAsiento2_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[15] = 0;
            }
        }

        val btnseleccionarAsiento2_7: ImageButton = findViewById(R.id.roomSeat2_7)

        btnseleccionarAsiento2_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[16] == 0){
                btnseleccionarAsiento2_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[16] = 1;
            } else if (seatsStatesArray[16] == 1){
                btnseleccionarAsiento2_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[16] = 0;
            }
        }

        val btnseleccionarAsiento2_8: ImageButton = findViewById(R.id.roomSeat2_8)

        btnseleccionarAsiento2_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[17] == 0){
                btnseleccionarAsiento2_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[17] = 1;
            } else if (seatsStatesArray[17] == 1){
                btnseleccionarAsiento2_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[17] = 0;
            }
        }

        val btnseleccionarAsiento2_9: ImageButton = findViewById(R.id.roomSeat2_9)

        btnseleccionarAsiento2_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[18] == 0){
                btnseleccionarAsiento2_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[18] = 1;
            } else if (seatsStatesArray[18] == 1){
                btnseleccionarAsiento2_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[18] = 0;
            }
        }

        val btnseleccionarAsiento2_10: ImageButton = findViewById(R.id.roomSeat2_10)

        btnseleccionarAsiento2_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[19] == 0){
                btnseleccionarAsiento2_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[19] = 1;
            } else if (seatsStatesArray[19] == 1){
                btnseleccionarAsiento2_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[19] = 0;
            }
        }

        //

        val btnseleccionarAsiento3_1: ImageButton = findViewById(R.id.roomSeat3_1)

        btnseleccionarAsiento3_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[20] == 0){
                btnseleccionarAsiento3_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[20] = 1;
            } else if (seatsStatesArray[20] == 1){
                btnseleccionarAsiento3_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[20] = 0;
            }
        }

        val btnseleccionarAsiento3_2: ImageButton = findViewById(R.id.roomSeat3_2)

        btnseleccionarAsiento3_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[21] == 0){
                btnseleccionarAsiento3_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[21] = 1;
            } else if (seatsStatesArray[21] == 1){
                btnseleccionarAsiento3_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[21] = 0;
            }
        }

        val btnseleccionarAsiento3_3: ImageButton = findViewById(R.id.roomSeat3_3)

        btnseleccionarAsiento3_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[22] == 0){
                btnseleccionarAsiento3_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[22] = 1;
            } else if (seatsStatesArray[22] == 1){
                btnseleccionarAsiento3_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[22] = 0;
            }
        }

        val btnseleccionarAsiento3_4: ImageButton = findViewById(R.id.roomSeat3_4)

        btnseleccionarAsiento3_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[23] == 0){
                btnseleccionarAsiento3_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[23] = 1;
            } else if (seatsStatesArray[23] == 1){
                btnseleccionarAsiento3_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[23] = 0;
            }
        }

        val btnseleccionarAsiento3_5: ImageButton = findViewById(R.id.roomSeat3_5)

        btnseleccionarAsiento3_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[24] == 0){
                btnseleccionarAsiento3_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[24] = 1;
            } else if (seatsStatesArray[24] == 1){
                btnseleccionarAsiento3_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[24] = 0;
            }
        }

        val btnseleccionarAsiento3_6: ImageButton = findViewById(R.id.roomSeat3_6)

        btnseleccionarAsiento3_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[25] == 0){
                btnseleccionarAsiento3_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[25] = 1;
            } else if (seatsStatesArray[25] == 1){
                btnseleccionarAsiento3_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[25] = 0;
            }
        }

        val btnseleccionarAsiento3_7: ImageButton = findViewById(R.id.roomSeat3_7)

        btnseleccionarAsiento3_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[26] == 0){
                btnseleccionarAsiento3_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[26] = 1;
            } else if (seatsStatesArray[26] == 1){
                btnseleccionarAsiento3_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[26] = 0;
            }
        }

        val btnseleccionarAsiento3_8: ImageButton = findViewById(R.id.roomSeat3_8)

        btnseleccionarAsiento3_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[27] == 0){
                btnseleccionarAsiento3_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[27] = 1;
            } else if (seatsStatesArray[27] == 1){
                btnseleccionarAsiento3_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[27] = 0;
            }
        }

        val btnseleccionarAsiento3_9: ImageButton = findViewById(R.id.roomSeat3_9)

        btnseleccionarAsiento3_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[28] == 0){
                btnseleccionarAsiento3_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[28] = 1;
            } else if (seatsStatesArray[28] == 1){
                btnseleccionarAsiento3_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[28] = 0;
            }
        }

        val btnseleccionarAsiento3_10: ImageButton = findViewById(R.id.roomSeat3_10)

        btnseleccionarAsiento3_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[29] == 0){
                btnseleccionarAsiento3_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[29] = 1;
            } else if (seatsStatesArray[29] == 1){
                btnseleccionarAsiento3_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[29] = 0;
            }
        }

        //

        val btnseleccionarAsiento4_1: ImageButton = findViewById(R.id.roomSeat4_1)

        btnseleccionarAsiento4_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[30] == 0){
                btnseleccionarAsiento4_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[30] = 1;
            } else if (seatsStatesArray[30] == 1){
                btnseleccionarAsiento4_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[30] = 0;
            }
        }

        val btnseleccionarAsiento4_2: ImageButton = findViewById(R.id.roomSeat4_2)

        btnseleccionarAsiento4_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[31] == 0){
                btnseleccionarAsiento4_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[31] = 1;
            } else if (seatsStatesArray[31] == 1){
                btnseleccionarAsiento4_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[31] = 0;
            }
        }

        val btnseleccionarAsiento4_3: ImageButton = findViewById(R.id.roomSeat4_3)

        btnseleccionarAsiento4_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[32] == 0){
                btnseleccionarAsiento4_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[32] = 1;
            } else if (seatsStatesArray[32] == 1){
                btnseleccionarAsiento4_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[32] = 0;
            }
        }

        val btnseleccionarAsiento4_4: ImageButton = findViewById(R.id.roomSeat4_4)

        btnseleccionarAsiento4_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[33] == 0){
                btnseleccionarAsiento4_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[33] = 1;
            } else if (seatsStatesArray[33] == 1){
                btnseleccionarAsiento4_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[33] = 0;
            }
        }

        val btnseleccionarAsiento4_5: ImageButton = findViewById(R.id.roomSeat4_5)

        btnseleccionarAsiento4_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[34] == 0){
                btnseleccionarAsiento4_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[34] = 1;
            } else if (seatsStatesArray[34] == 1){
                btnseleccionarAsiento4_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[34] = 0;
            }
        }

        val btnseleccionarAsiento4_6: ImageButton = findViewById(R.id.roomSeat4_6)

        btnseleccionarAsiento4_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[35] == 0){
                btnseleccionarAsiento4_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[35] = 1;
            } else if (seatsStatesArray[35] == 1){
                btnseleccionarAsiento4_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[35] = 0;
            }
        }

        val btnseleccionarAsiento4_7: ImageButton = findViewById(R.id.roomSeat4_7)

        btnseleccionarAsiento4_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[36] == 0){
                btnseleccionarAsiento4_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[36] = 1;
            } else if (seatsStatesArray[36] == 1){
                btnseleccionarAsiento4_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[36] = 0;
            }
        }

        val btnseleccionarAsiento4_8: ImageButton = findViewById(R.id.roomSeat4_8)

        btnseleccionarAsiento4_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[37] == 0){
                btnseleccionarAsiento4_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[37] = 1;
            } else if (seatsStatesArray[37] == 1){
                btnseleccionarAsiento4_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[37] = 0;
            }
        }

        val btnseleccionarAsiento4_9: ImageButton = findViewById(R.id.roomSeat4_9)

        btnseleccionarAsiento4_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[38] == 0){
                btnseleccionarAsiento4_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[38] = 1;
            } else if (seatsStatesArray[38] == 1){
                btnseleccionarAsiento4_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[38] = 0;
            }
        }

        val btnseleccionarAsiento4_10: ImageButton = findViewById(R.id.roomSeat4_10)

        btnseleccionarAsiento4_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[39] == 0){
                btnseleccionarAsiento4_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[39] = 1;
            } else if (seatsStatesArray[39] == 1){
                btnseleccionarAsiento4_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[39] = 0;
            }
        }

        //

        val btnseleccionarAsiento5_1: ImageButton = findViewById(R.id.roomSeat5_1)

        btnseleccionarAsiento5_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[40] == 0){
                btnseleccionarAsiento5_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[40] = 1;
            } else if (seatsStatesArray[40] == 1){
                btnseleccionarAsiento5_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[40] = 0;
            }
        }

        val btnseleccionarAsiento5_2: ImageButton = findViewById(R.id.roomSeat5_2)

        btnseleccionarAsiento5_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[41] == 0){
                btnseleccionarAsiento5_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[41] = 1;
            } else if (seatsStatesArray[41] == 1){
                btnseleccionarAsiento5_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[41] = 0;
            }
        }

        val btnseleccionarAsiento5_3: ImageButton = findViewById(R.id.roomSeat5_3)

        btnseleccionarAsiento5_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[42] == 0){
                btnseleccionarAsiento5_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[42] = 1;
            } else if (seatsStatesArray[42] == 1){
                btnseleccionarAsiento5_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[42] = 0;
            }
        }

        val btnseleccionarAsiento5_4: ImageButton = findViewById(R.id.roomSeat5_4)

        btnseleccionarAsiento5_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[43] == 0){
                btnseleccionarAsiento5_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[43] = 1;
            } else if (seatsStatesArray[43] == 1){
                btnseleccionarAsiento5_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[43] = 0;
            }
        }

        val btnseleccionarAsiento5_5: ImageButton = findViewById(R.id.roomSeat5_5)

        btnseleccionarAsiento5_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[44] == 0){
                btnseleccionarAsiento5_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[44] = 1;
            } else if (seatsStatesArray[44] == 1){
                btnseleccionarAsiento5_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[44] = 0;
            }
        }

        val btnseleccionarAsiento5_6: ImageButton = findViewById(R.id.roomSeat5_6)

        btnseleccionarAsiento5_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[45] == 0){
                btnseleccionarAsiento5_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[45] = 1;
            } else if (seatsStatesArray[45] == 1){
                btnseleccionarAsiento5_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[45] = 0;
            }
        }

        val btnseleccionarAsiento5_7: ImageButton = findViewById(R.id.roomSeat5_7)

        btnseleccionarAsiento5_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[46] == 0){
                btnseleccionarAsiento5_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[46] = 1;
            } else if (seatsStatesArray[46] == 1){
                btnseleccionarAsiento5_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[46] = 0;
            }
        }

        val btnseleccionarAsiento5_8: ImageButton = findViewById(R.id.roomSeat5_8)

        btnseleccionarAsiento5_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[47] == 0){
                btnseleccionarAsiento5_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[47] = 1;
            } else if (seatsStatesArray[47] == 1){
                btnseleccionarAsiento5_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[47] = 0;
            }
        }

        val btnseleccionarAsiento5_9: ImageButton = findViewById(R.id.roomSeat5_9)

        btnseleccionarAsiento5_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[48] == 0){
                btnseleccionarAsiento5_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[48] = 1;
            } else if (seatsStatesArray[48] == 1){
                btnseleccionarAsiento5_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[48] = 0;
            }
        }

        val btnseleccionarAsiento5_10: ImageButton = findViewById(R.id.roomSeat5_10)

        btnseleccionarAsiento5_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[49] == 0){
                btnseleccionarAsiento5_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[49] = 1;
            } else if (seatsStatesArray[49] == 1){
                btnseleccionarAsiento5_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[49] = 0;
            }
        }

        //

        val btnseleccionarAsiento6_1: ImageButton = findViewById(R.id.roomSeat6_1)

        btnseleccionarAsiento6_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[50] == 0){
                btnseleccionarAsiento6_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[50] = 1;
            } else if (seatsStatesArray[50] == 1){
                btnseleccionarAsiento6_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[50] = 0;
            }
        }

        val btnseleccionarAsiento6_2: ImageButton = findViewById(R.id.roomSeat6_2)

        btnseleccionarAsiento6_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[51] == 0){
                btnseleccionarAsiento6_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[51] = 1;
            } else if (seatsStatesArray[51] == 1){
                btnseleccionarAsiento6_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[51] = 0;
            }
        }

        val btnseleccionarAsiento6_3: ImageButton = findViewById(R.id.roomSeat6_3)

        btnseleccionarAsiento6_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[52] == 0){
                btnseleccionarAsiento6_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[52] = 1;
            } else if (seatsStatesArray[52] == 1){
                btnseleccionarAsiento6_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[52] = 0;
            }
        }

        val btnseleccionarAsiento6_4: ImageButton = findViewById(R.id.roomSeat6_4)

        btnseleccionarAsiento6_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[53] == 0){
                btnseleccionarAsiento6_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[53] = 1;
            } else if (seatsStatesArray[53] == 1){
                btnseleccionarAsiento6_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[53] = 0;
            }
        }

        val btnseleccionarAsiento6_5: ImageButton = findViewById(R.id.roomSeat6_5)

        btnseleccionarAsiento6_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[54] == 0){
                btnseleccionarAsiento6_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[54] = 1;
            } else if (seatsStatesArray[54] == 1){
                btnseleccionarAsiento6_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[54] = 0;
            }
        }

        val btnseleccionarAsiento6_6: ImageButton = findViewById(R.id.roomSeat6_6)

        btnseleccionarAsiento6_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[55] == 0){
                btnseleccionarAsiento6_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[55] = 1;
            } else if (seatsStatesArray[55] == 1){
                btnseleccionarAsiento6_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[55] = 0;
            }
        }

        val btnseleccionarAsiento6_7: ImageButton = findViewById(R.id.roomSeat6_7)

        btnseleccionarAsiento6_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[56] == 0){
                btnseleccionarAsiento6_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[56] = 1;
            } else if (seatsStatesArray[56] == 1){
                btnseleccionarAsiento6_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[56] = 0;
            }
        }

        val btnseleccionarAsiento6_8: ImageButton = findViewById(R.id.roomSeat6_8)

        btnseleccionarAsiento6_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[57] == 0){
                btnseleccionarAsiento6_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[57] = 1;
            } else if (seatsStatesArray[57] == 1){
                btnseleccionarAsiento6_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[57] = 0;
            }
        }

        val btnseleccionarAsiento6_9: ImageButton = findViewById(R.id.roomSeat6_9)

        btnseleccionarAsiento6_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[58] == 0){
                btnseleccionarAsiento6_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[58] = 1;
            } else if (seatsStatesArray[58] == 1){
                btnseleccionarAsiento6_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[58] = 0;
            }
        }

        val btnseleccionarAsiento6_10: ImageButton = findViewById(R.id.roomSeat6_10)

        btnseleccionarAsiento6_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[59] == 0){
                btnseleccionarAsiento6_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[59] = 1;
            } else if (seatsStatesArray[59] == 1){
                btnseleccionarAsiento6_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[59] = 0;
            }
        }

        //

        val btnseleccionarAsiento7_1: ImageButton = findViewById(R.id.roomSeat7_1)

        btnseleccionarAsiento7_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[60] == 0){
                btnseleccionarAsiento7_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[60] = 1;
            } else if (seatsStatesArray[60] == 1){
                btnseleccionarAsiento7_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[60] = 0;
            }
        }

        val btnseleccionarAsiento7_2: ImageButton = findViewById(R.id.roomSeat7_2)

        btnseleccionarAsiento7_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[61] == 0){
                btnseleccionarAsiento7_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[61] = 1;
            } else if (seatsStatesArray[61] == 1){
                btnseleccionarAsiento7_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[61] = 0;
            }
        }

        val btnseleccionarAsiento7_3: ImageButton = findViewById(R.id.roomSeat7_3)

        btnseleccionarAsiento7_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[62] == 0){
                btnseleccionarAsiento7_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[62] = 1;
            } else if (seatsStatesArray[62] == 1){
                btnseleccionarAsiento7_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[62] = 0;
            }
        }

        val btnseleccionarAsiento7_4: ImageButton = findViewById(R.id.roomSeat7_4)

        btnseleccionarAsiento7_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[63] == 0){
                btnseleccionarAsiento7_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[63] = 1;
            } else if (seatsStatesArray[63] == 1){
                btnseleccionarAsiento7_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[63] = 0;
            }
        }

        val btnseleccionarAsiento7_5: ImageButton = findViewById(R.id.roomSeat7_5)

        btnseleccionarAsiento7_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[64] == 0){
                btnseleccionarAsiento7_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[64] = 1;
            } else if (seatsStatesArray[64] == 1){
                btnseleccionarAsiento7_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[64] = 0;
            }
        }

        val btnseleccionarAsiento7_6: ImageButton = findViewById(R.id.roomSeat7_6)

        btnseleccionarAsiento7_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[65] == 0){
                btnseleccionarAsiento7_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[65] = 1;
            } else if (seatsStatesArray[65] == 1){
                btnseleccionarAsiento7_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[65] = 0;
            }
        }

        val btnseleccionarAsiento7_7: ImageButton = findViewById(R.id.roomSeat7_7)

        btnseleccionarAsiento7_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[66] == 0){
                btnseleccionarAsiento7_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[66] = 1;
            } else if (seatsStatesArray[66] == 1){
                btnseleccionarAsiento7_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[66] = 0;
            }
        }

        val btnseleccionarAsiento7_8: ImageButton = findViewById(R.id.roomSeat7_8)

        btnseleccionarAsiento7_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[67] == 0){
                btnseleccionarAsiento7_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[67] = 1;
            } else if (seatsStatesArray[67] == 1){
                btnseleccionarAsiento7_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[67] = 0;
            }
        }

        val btnseleccionarAsiento7_9: ImageButton = findViewById(R.id.roomSeat7_9)

        btnseleccionarAsiento7_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[68] == 0){
                btnseleccionarAsiento7_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[68] = 1;
            } else if (seatsStatesArray[68] == 1){
                btnseleccionarAsiento7_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[68] = 0;
            }
        }

        val btnseleccionarAsiento7_10: ImageButton = findViewById(R.id.roomSeat7_10)

        btnseleccionarAsiento7_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[69] == 0){
                btnseleccionarAsiento7_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[69] = 1;
            } else if (seatsStatesArray[69] == 1){
                btnseleccionarAsiento7_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[69] = 0;
            }
        }

        //

        val btnseleccionarAsiento8_1: ImageButton = findViewById(R.id.roomSeat8_1)

        btnseleccionarAsiento8_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[70] == 0){
                btnseleccionarAsiento8_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[70] = 1;
            } else if (seatsStatesArray[70] == 1){
                btnseleccionarAsiento8_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[70] = 0;
            }
        }

        val btnseleccionarAsiento8_2: ImageButton = findViewById(R.id.roomSeat8_2)

        btnseleccionarAsiento8_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[71] == 0){
                btnseleccionarAsiento8_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[71] = 1;
            } else if (seatsStatesArray[71] == 1){
                btnseleccionarAsiento8_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[71] = 0;
            }
        }

        val btnseleccionarAsiento8_3: ImageButton = findViewById(R.id.roomSeat8_3)

        btnseleccionarAsiento8_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[72] == 0){
                btnseleccionarAsiento8_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[72] = 1;
            } else if (seatsStatesArray[72] == 1){
                btnseleccionarAsiento8_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[72] = 0;
            }
        }

        val btnseleccionarAsiento8_4: ImageButton = findViewById(R.id.roomSeat8_4)

        btnseleccionarAsiento8_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[73] == 0){
                btnseleccionarAsiento8_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[73] = 1;
            } else if (seatsStatesArray[73] == 1){
                btnseleccionarAsiento8_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[73] = 0;
            }
        }

        val btnseleccionarAsiento8_5: ImageButton = findViewById(R.id.roomSeat8_5)

        btnseleccionarAsiento8_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[74] == 0){
                btnseleccionarAsiento8_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[74] = 1;
            } else if (seatsStatesArray[74] == 1){
                btnseleccionarAsiento8_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[74] = 0;
            }
        }

        val btnseleccionarAsiento8_6: ImageButton = findViewById(R.id.roomSeat8_6)

        btnseleccionarAsiento8_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[75] == 0){
                btnseleccionarAsiento8_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[75] = 1;
            } else if (seatsStatesArray[75] == 1){
                btnseleccionarAsiento8_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[75] = 0;
            }
        }

        val btnseleccionarAsiento8_7: ImageButton = findViewById(R.id.roomSeat8_7)

        btnseleccionarAsiento8_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[76] == 0){
                btnseleccionarAsiento8_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[76] = 1;
            } else if (seatsStatesArray[76] == 1){
                btnseleccionarAsiento8_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[76] = 0;
            }
        }

        val btnseleccionarAsiento8_8: ImageButton = findViewById(R.id.roomSeat8_8)

        btnseleccionarAsiento8_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[77] == 0){
                btnseleccionarAsiento8_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[77] = 1;
            } else if (seatsStatesArray[77] == 1){
                btnseleccionarAsiento8_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[77] = 0;
            }
        }

        val btnseleccionarAsiento8_9: ImageButton = findViewById(R.id.roomSeat8_9)

        btnseleccionarAsiento8_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[78] == 0){
                btnseleccionarAsiento8_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[78] = 1;
            } else if (seatsStatesArray[78] == 1){
                btnseleccionarAsiento8_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[78] = 0;
            }
        }

        val btnseleccionarAsiento8_10: ImageButton = findViewById(R.id.roomSeat8_10)

        btnseleccionarAsiento8_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[79] == 0){
                btnseleccionarAsiento8_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[79] = 1;
            } else if (seatsStatesArray[79] == 1){
                btnseleccionarAsiento8_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[79] = 0;
            }
        }

        //

        val btnseleccionarAsiento9_1: ImageButton = findViewById(R.id.roomSeat9_1)

        btnseleccionarAsiento9_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[80] == 0){
                btnseleccionarAsiento9_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[80] = 1;
            } else if (seatsStatesArray[80] == 1){
                btnseleccionarAsiento9_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[80] = 0;
            }
        }

        val btnseleccionarAsiento9_2: ImageButton = findViewById(R.id.roomSeat9_2)

        btnseleccionarAsiento9_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[81] == 0){
                btnseleccionarAsiento9_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[81] = 1;
            } else if (seatsStatesArray[81] == 1){
                btnseleccionarAsiento9_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[81] = 0;
            }
        }

        val btnseleccionarAsiento9_3: ImageButton = findViewById(R.id.roomSeat9_3)

        btnseleccionarAsiento9_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[82] == 0){
                btnseleccionarAsiento9_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[82] = 1;
            } else if (seatsStatesArray[82] == 1){
                btnseleccionarAsiento9_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[82] = 0;
            }
        }

        val btnseleccionarAsiento9_4: ImageButton = findViewById(R.id.roomSeat9_4)

        btnseleccionarAsiento9_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[83] == 0){
                btnseleccionarAsiento9_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[83] = 1;
            } else if (seatsStatesArray[83] == 1){
                btnseleccionarAsiento9_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[83] = 0;
            }
        }

        val btnseleccionarAsiento9_5: ImageButton = findViewById(R.id.roomSeat9_5)

        btnseleccionarAsiento9_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[84] == 0){
                btnseleccionarAsiento9_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[84] = 1;
            } else if (seatsStatesArray[84] == 1){
                btnseleccionarAsiento9_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[84] = 0;
            }
        }

        val btnseleccionarAsiento9_6: ImageButton = findViewById(R.id.roomSeat9_6)

        btnseleccionarAsiento9_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[85] == 0){
                btnseleccionarAsiento9_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[85] = 1;
            } else if (seatsStatesArray[85] == 1){
                btnseleccionarAsiento9_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[85] = 0;
            }
        }

        val btnseleccionarAsiento9_7: ImageButton = findViewById(R.id.roomSeat9_7)

        btnseleccionarAsiento9_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[86] == 0){
                btnseleccionarAsiento9_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[86] = 1;
            } else if (seatsStatesArray[86] == 1){
                btnseleccionarAsiento9_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[86] = 0;
            }
        }

        val btnseleccionarAsiento9_8: ImageButton = findViewById(R.id.roomSeat9_8)

        btnseleccionarAsiento9_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[87] == 0){
                btnseleccionarAsiento9_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[87] = 1;
            } else if (seatsStatesArray[87] == 1){
                btnseleccionarAsiento9_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[87] = 0;
            }
        }

        val btnseleccionarAsiento9_9: ImageButton = findViewById(R.id.roomSeat9_9)

        btnseleccionarAsiento9_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[88] == 0){
                btnseleccionarAsiento9_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[88] = 1;
            } else if (seatsStatesArray[88] == 1){
                btnseleccionarAsiento9_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[88] = 0;
            }
        }

        val btnseleccionarAsiento9_10: ImageButton = findViewById(R.id.roomSeat9_10)

        btnseleccionarAsiento9_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[89] == 0){
                btnseleccionarAsiento9_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[89] = 1;
            } else if (seatsStatesArray[89] == 1){
                btnseleccionarAsiento9_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[89] = 0;
            }
        }

        //

        val btnseleccionarAsiento10_1: ImageButton = findViewById(R.id.roomSeat10_1)

        btnseleccionarAsiento10_1.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[90] == 0){
                btnseleccionarAsiento10_1.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[90] = 1;
            } else if (seatsStatesArray[90] == 1){
                btnseleccionarAsiento10_1.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[90] = 0;
            }
        }

        val btnseleccionarAsiento10_2: ImageButton = findViewById(R.id.roomSeat10_2)

        btnseleccionarAsiento10_2.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[91] == 0){
                btnseleccionarAsiento10_2.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[91] = 1;
            } else if (seatsStatesArray[91] == 1){
                btnseleccionarAsiento10_2.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[91] = 0;
            }
        }

        val btnseleccionarAsiento10_3: ImageButton = findViewById(R.id.roomSeat10_3)

        btnseleccionarAsiento10_3.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[92] == 0){
                btnseleccionarAsiento10_3.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[92] = 1;
            } else if (seatsStatesArray[92] == 1){
                btnseleccionarAsiento10_3.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[92] = 0;
            }
        }

        val btnseleccionarAsiento10_4: ImageButton = findViewById(R.id.roomSeat10_4)

        btnseleccionarAsiento10_4.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[93] == 0){
                btnseleccionarAsiento10_4.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[93] = 1;
            } else if (seatsStatesArray[93] == 1){
                btnseleccionarAsiento10_4.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[93] = 0;
            }
        }

        val btnseleccionarAsiento10_5: ImageButton = findViewById(R.id.roomSeat10_5)

        btnseleccionarAsiento10_5.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[94] == 0){
                btnseleccionarAsiento10_5.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[94] = 1;
            } else if (seatsStatesArray[94] == 1){
                btnseleccionarAsiento10_5.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[94] = 0;
            }
        }

        val btnseleccionarAsiento10_6: ImageButton = findViewById(R.id.roomSeat10_6)

        btnseleccionarAsiento10_6.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[95] == 0){
                btnseleccionarAsiento10_6.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[95] = 1;
            } else if (seatsStatesArray[95] == 1){
                btnseleccionarAsiento10_6.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[95] = 0;
            }
        }

        val btnseleccionarAsiento10_7: ImageButton = findViewById(R.id.roomSeat10_7)

        btnseleccionarAsiento10_7.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[96] == 0){
                btnseleccionarAsiento10_7.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[96] = 1;
            } else if (seatsStatesArray[96] == 1){
                btnseleccionarAsiento10_7.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[96] = 0;
            }
        }

        val btnseleccionarAsiento10_8: ImageButton = findViewById(R.id.roomSeat10_8)

        btnseleccionarAsiento10_8.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[97] == 0){
                btnseleccionarAsiento10_8.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[97] = 1;
            } else if (seatsStatesArray[97] == 1){
                btnseleccionarAsiento10_8.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[97] = 0;
            }
        }

        val btnseleccionarAsiento10_9: ImageButton = findViewById(R.id.roomSeat10_9)

        btnseleccionarAsiento10_9.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[98] == 0){
                btnseleccionarAsiento10_9.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[98] = 1;
            } else if (seatsStatesArray[98] == 1){
                btnseleccionarAsiento10_9.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[98] = 0;
            }
        }

        val btnseleccionarAsiento10_10: ImageButton = findViewById(R.id.roomSeat10_10)

        btnseleccionarAsiento10_10.setOnClickListener {
            if(selectedSeats < totalSpecifiedSeats && seatsStatesArray[99] == 0){
                btnseleccionarAsiento10_10.setImageResource(R.drawable.selected_seat_icon)
                selectedSeats++;
                seatsStatesArray[99] = 1;
            } else if (seatsStatesArray[99] == 1){
                btnseleccionarAsiento10_10.setImageResource(R.drawable.available_seat_icon)
                selectedSeats--;
                seatsStatesArray[99] = 0;
            }
        }
    }
}