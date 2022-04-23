package com.example.rajamantrichorsipahi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InputNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_name)

        val enterButton: Button = findViewById(R.id.enterButton)
        enterButton.setOnClickListener {
            val viewer1: TextView = findViewById(R.id.person1)
            val viewer2: TextView = findViewById(R.id.person2)
            val viewer3: TextView = findViewById(R.id.person3)
            val viewer4: TextView = findViewById(R.id.person4)


            if (viewer1.text.toString().isEmpty()) {
                viewer1.setError("text is required")
            } else if (viewer2.text.toString().isEmpty()) {
                viewer2.setError("text is required")
            } else if (viewer3.text.toString().isEmpty()) {
                viewer3.setError("text is required")
            } else if (viewer4.text.toString().isEmpty()) {
                viewer4.setError("text is required")
            }
         else {
            val bundle = Bundle()
            val intent = Intent(this, PlayGroundActivity::class.java)

            bundle.putString("pv1", viewer1.text.toString())
            bundle.putString("pv2", viewer2.text.toString())
            bundle.putString("pv3", viewer3.text.toString())
            bundle.putString("pv4", viewer4.text.toString())
            intent.putExtras(bundle)
//            intent.putExtra(PlayGroundActivity.Name_Extra1,name1)
//            intent.putExtra(PlayGroundActivity.Name_Extra2,name2)
//            intent.putExtra(PlayGroundActivity.Name_Extra3,name3)
//            intent.putExtra(PlayGroundActivity.Name_Extra4,name4)
            startActivity(intent)
            finish()
            }
        }
    }
}