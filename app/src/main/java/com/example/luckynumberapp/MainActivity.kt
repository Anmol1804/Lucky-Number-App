package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btn)
        val tvTitle : TextView = findViewById(R.id.tvTitle)
        val etName : EditText = findViewById(R.id.etName)

        btn.setOnClickListener {
            val name = etName.text

            // EXPLICIT INTENT
            val i = Intent(this, LuckyNumberActivity::class.java)
            i.putExtra("name", name)
            startActivity(i)
        }

    }
}