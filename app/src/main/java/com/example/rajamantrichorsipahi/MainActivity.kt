package com.example.rajamantrichorsipahi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn : Button = findViewById(R.id.playButton)
        playBtn.setOnClickListener {
            val intent = Intent(this,InputNameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}