package com.example.rajamantrichorsipahi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class congrats_show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats_show)
        val butt : Button = findViewById(R.id.new_start)

        butt.setOnClickListener {
            val intent = Intent(this,InputNameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}