package com.example.luckynumberapp

import android.app.Notification.Action
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number)

        val btnShare : Button = findViewById(R.id.btnShare)
        val tvNumTitle : TextView = findViewById(R.id.tvNumTitle)
        val tvNum : TextView = findViewById(R.id.tvNum)

        val user_name = recievename()
        val luckyNum = generateRandomNumber()

        tvNum.setText(luckyNum.toString())

        btnShare.setOnClickListener(){
            sharingResult(user_name, luckyNum)
        }

    }

    fun recievename() : String {
        val bundle : Bundle? = intent.extras
        val username = bundle?.get("name").toString()

        return username
    }

    fun generateRandomNumber() : Int{
        val random = Random.nextInt(0,1000)
        return random
    }

    // sharing
    fun sharingResult(username:String, num: Int){

        // implicit initent
        val i : Intent = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is Lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is $num")
        startActivity(i)
    }
}