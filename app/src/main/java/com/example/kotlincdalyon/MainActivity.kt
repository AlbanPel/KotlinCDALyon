package com.example.kotlincdalyon

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //ADD Button
        val button = findViewById<Button>(R.id.start_new_activity_btn)
        button.setOnClickListener{
            val intent = Intent(this, NewActivity::class.java)
            //ADD ACTION
            intent.action = Intent.ACTION_VIEW
            //ADD CATEGORY
            intent.addCategory("user")
            //ADD EXTRAT
            intent.putExtra("name", "Alban")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        //New button for parcelable
        var profile = Profile("Alban", 25)
        val buttonParcelable = findViewById<Button>(R.id.my_profile)
        buttonParcelable.setOnClickListener{
            val intentProfile = Intent(this, ProfileDetailsActivity::class.java)
            intentProfile.putExtra("profile", profile)
            startActivity(intentProfile)
        }

    //LOG
        Log.v("MainActivity", "Verbose message")
        Log.d("MainActivity", "Debug Message")
        Log.i(TAG, "Info message")
        Log.w(TAG, "Warning message")
        Log.e(TAG, "Error message")
        Log.println(Log.ASSERT, TAG, "Assert message")


    }
}