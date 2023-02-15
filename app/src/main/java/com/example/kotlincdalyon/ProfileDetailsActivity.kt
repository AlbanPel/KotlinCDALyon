package com.example.kotlincdalyon

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileDetailsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)
        //Catch Profile in MainActivity
        val profile:Profile = intent.getParcelableExtra("profile")!!
        val nameTextView = findViewById<TextView>(R.id.name)
        val ageTextView = findViewById<TextView>(R.id.age)

        nameTextView.setText("NOM : ${profile?.name}")
        ageTextView.setText("AGE: ${profile?.age}")


        //Dialog Button
    }
}