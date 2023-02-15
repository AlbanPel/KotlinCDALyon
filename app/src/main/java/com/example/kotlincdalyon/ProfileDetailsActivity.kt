package com.example.kotlincdalyon

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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


        //Create dialog button
        findViewById<Button>(R.id.show_dialog_button).setOnClickListener {
            val fragment = ConfirmationDeleteDialogFragment()
            fragment.listener = object: ConfirmationDeleteDialogFragment.ConfirmationDeleteListener{

                override fun onDialogPosistiveClick() {
                    val fragment = FileListDialogFragment()
                    fragment.show(supportFragmentManager, "FileListDialogFragment")
                }

                override fun onDialogNegativeClick() {}
            }
            //afficher le dialog
            fragment.show(supportFragmentManager, "FileListDialogFragment")
        }
    }
}