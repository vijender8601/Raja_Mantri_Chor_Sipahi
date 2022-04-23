package com.example.rajamantrichorsipahi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PlayGroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_ground)

//        val name1 = intent.getStringExtra(Name_Extra1)
//        val name2 = intent.getStringExtra(Name_Extra2)
//        val name3 = intent.getStringExtra(Name_Extra3)
//        val name4 = intent.getStringExtra(Name_Extra4)
//
//        val view1: TextView = findViewById(R.id.personView1)
//        val view2: TextView = findViewById(R.id.personView2)
//        val view3: TextView = findViewById(R.id.personView3)
//        val view4: TextView = findViewById(R.id.personView4)
//
//        view1.text = "$name1"
//        view2.text = "$name2"
//        view3.text = "$name3"
//        view4.text = "$name4"

        val pv1: TextView = findViewById(R.id.personView1)
        val pv2: TextView = findViewById(R.id.personView2)
        val pv3: TextView = findViewById(R.id.personView3)
        val pv4: TextView = findViewById(R.id.personView4)

        val bundle = intent.extras
        if(bundle!=null)
        {
            pv1.text = "${bundle.getString("pv1")}"
            pv2.text = "${bundle.getString("pv2")}"
            pv3.text = "${bundle.getString("pv3")}"
            pv4.text = "${bundle.getString("pv4")}"
        }
        val chk1 = pv1.text
        val chk2 = pv2.text
        val chk3 = pv3.text
        val chk4 = pv4.text
        val arr = arrayOf<String>("राजा","चोर","मंत्री","सिपाही")
//        arr.shuffle()
//        for (i in 0..arr.size-1)
//        {
//            print(arr[i]+" ")
//        }
        var pl1 = 0
        var pl2 = 0
        var pl3 = 0
        var pl4= 0

        val shuffle: Button = findViewById(R.id.shuffle)

        val show1:TextView = findViewById(R.id.show1)
        val show2:TextView = findViewById(R.id.show2)
        val show3:TextView = findViewById(R.id.show3)
        val show4:TextView = findViewById(R.id.show4)

        val paper1:ImageView = findViewById(R.id.paper1)
        val paper2:ImageView = findViewById(R.id.paper2)
        val paper3:ImageView = findViewById(R.id.paper3)
        val paper4:ImageView = findViewById(R.id.paper4)
        var x_ = ""
        var y_ = ""
        var click_chk = 0
        shuffle.setOnClickListener {
            if(click_chk==0) {
                click_chk=1
                arr.shuffle()

                if (arr[0] == "राजा") {
                    show1.text = arr[0]
                    pl1 += 1000
                }
                if (arr[1] == "राजा") {
                    show2.text = arr[1]
                    pl2 += 1000
                }
                if (arr[2] == "राजा") {
                    show3.text = arr[2]
                    pl3 += 1000
                }
                if (arr[3] == "राजा") {
                    show4.text = arr[3]
                    pl4 += 1000
                }

                if (arr[0] == "मंत्री") show1.text = arr[0]
                if (arr[1] == "मंत्री") show2.text = arr[1]
                if (arr[2] == "मंत्री") show3.text = arr[2]
                if (arr[3] == "मंत्री") show4.text = arr[3]

                if (arr[0] == "सिपाही") {
                    show1.text = ""
                    x_ = chk1.toString()
                }
                if (arr[1] == "सिपाही") {
                    show2.text = ""
                    x_ = chk2.toString()
                }
                if (arr[2] == "सिपाही") {
                    show3.text = ""
                    x_ = chk3.toString()
                }
                if (arr[3] == "सिपाही") {
                    show4.text = ""
                    x_ = chk4.toString()
                }

                if (arr[0] == "चोर") {
                    show1.text = ""
                    y_ = chk1.toString()
                }
                if (arr[1] == "चोर") {
                    show2.text = ""
                    y_ = chk2.toString()
                }
                if (arr[2] == "चोर") {
                    show3.text = ""
                    y_ = chk3.toString()
                }
                if (arr[3] == "चोर") {
                    show4.text = ""
                    y_ = chk4.toString()
                }

                Toast.makeText(
                    this, "राजा :- मंत्री मंत्री।\n" +
                            "\n" +
                            "मंत्री :-  जी हुजूर..\n" +
                            "\n" +
                            "राजा :-  $x_ और $y_ में से चोर का पता लगाओ।", Toast.LENGTH_SHORT
                ).show()


                if (arr[0] == "चोर") {
                    if (arr[1] == "सिपाही") {
                        paper1.bringToFront()
                        paper2.bringToFront()
                        pv1.bringToFront()
                        pv2.bringToFront()

                        paper1.setOnClickListener {
                            if (click_chk == 1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl1 += 0
                                pl2 += 500
                                if (arr[2] == "मंत्री") pl3 += 800
                                if (arr[3] == "मंत्री") pl4 += 800
                                show1.text = "चोर"
                                show2.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show2.bringToFront()
                                click_chk = 0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        paper2.setOnClickListener {
                            if (click_chk == 1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl1 += 800
                                pl2 += 500
                                if (arr[2] == "मंत्री") pl3 += 0
                                if (arr[3] == "मंत्री") pl4 += 0
                                show1.text = "चोर"
                                show2.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show2.bringToFront()
                                click_chk = 0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }

                    if (arr[2] == "सिपाही") {
                        paper1.bringToFront()
                        paper3.bringToFront()
                        pv1.bringToFront()
                        pv3.bringToFront()

                        paper1.setOnClickListener {
                            if (click_chk == 1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl1 += 0
                                pl3 += 500
                                if (arr[1] == "मंत्री") pl2 += 800
                                if (arr[3] == "मंत्री") pl4 += 800
                                show1.text = "चोर"
                                show3.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show3.bringToFront()
                                click_chk = 0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        paper3.setOnClickListener {
                            if (click_chk == 1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl1 += 800
                                pl3 += 500
                                if (arr[1] == "मंत्री") pl2 += 0
                                if (arr[3] == "मंत्री") pl4 += 0
                                show1.text = "चोर"
                                show3.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show3.bringToFront()
                                click_chk = 0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }

                    if (arr[3] == "सिपाही") {
                        paper1.bringToFront()
                        paper4.bringToFront()
                        pv1.bringToFront()
                        pv4.bringToFront()

                        paper1.setOnClickListener {
                            if (click_chk == 1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl1 += 0
                                pl4 += 500
                                if (arr[2] == "मंत्री") pl3 += 800
                                if (arr[1] == "मंत्री") pl2 += 800
                                show1.text = "चोर"
                                show4.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show4.bringToFront()
                                click_chk = 0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        paper4.setOnClickListener {
                            if (click_chk == 1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl1 += 800
                                pl4 += 500
                                if (arr[1] == "मंत्री") pl2 += 0
                                if (arr[2] == "मंत्री") pl3 += 0
                                show1.text = "चोर"
                                show4.text = "सिपाही"

                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show4.bringToFront()
                                click_chk = 0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }

                if (arr[2] == "चोर") {
                    if (arr[0] == "सिपाही") {
                        paper3.bringToFront()
                        paper1.bringToFront()
                        pv1.bringToFront()
                        pv3.bringToFront()

                        paper3.setOnClickListener {

                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl3 += 0
                                pl1 += 500
                                if (arr[1] == "मंत्री") pl2 += 800
                                if (arr[3] == "मंत्री") pl4 += 800
                                show3.text = "चोर"
                                show1.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show3.bringToFront()
                                show1.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        paper1.setOnClickListener {
                           if(click_chk==1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl3 += 800
                                pl1 += 500
                                if (arr[1] == "मंत्री") pl3 += 0
                                if (arr[3] == "मंत्री") pl4 += 0
                                show3.text = "चोर"
                                show1.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show3.bringToFront()
                                show1.bringToFront()
                               click_chk=0
                               if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                   val intent = Intent(this, congrats_show::class.java)
                                   startActivity(intent)
                                   finish()
                               }
                            }
                        }
                    }

                    if (arr[1] == "सिपाही") {
                        paper2.bringToFront()
                        paper3.bringToFront()
                        pv2.bringToFront()
                        pv3.bringToFront()

                        paper3.setOnClickListener {
                           if(click_chk==1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl3 += 0
                                pl2 += 500
                                if (arr[0] == "मंत्री") pl1 += 800
                                if (arr[3] == "मंत्री") pl4 += 800
                                show3.text = "चोर"
                                show2.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show3.bringToFront()
                               click_chk=0
                               if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                   val intent = Intent(this, congrats_show::class.java)
                                   startActivity(intent)
                                   finish()
                               }
                            }
                        }
                        paper2.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl3 += 800
                                pl2 += 500
                                if (arr[0] == "मंत्री") pl1 += 0
                                if (arr[3] == "मंत्री") pl4 += 0
                                show3.text = "चोर"
                                show2.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show3.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }

                    if (arr[3] == "सिपाही") {
                        paper3.bringToFront()
                        paper4.bringToFront()
                        pv3.bringToFront()
                        pv4.bringToFront()

                        paper3.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl3 += 0
                                pl4 += 500
                                if (arr[0] == "मंत्री") pl1 += 800
                                if (arr[1] == "मंत्री") pl2 += 800
                                show3.text = "चोर"
                                show4.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show3.bringToFront()
                                show4.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }

                        }
                        paper4.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl3 += 800
                                pl4 += 500
                                if (arr[1] == "मंत्री") pl2 += 0
                                if (arr[0] == "मंत्री") pl1 += 0
                                show3.text = "चोर"
                                show4.text = "सिपाही"

                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show3.bringToFront()
                                show4.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }

                if (arr[1] == "चोर") {
                    if (arr[0] == "सिपाही") {
                        paper1.bringToFront()
                        paper2.bringToFront()
                        pv1.bringToFront()
                        pv2.bringToFront()

                        paper2.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl2 += 0
                                pl1 += 500
                                if (arr[2] == "मंत्री") pl3 += 800
                                if (arr[3] == "मंत्री") pl4 += 800
                                show2.text = "चोर"
                                show1.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show2.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        paper1.setOnClickListener {
                           if(click_chk==1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl2 += 800
                                pl1 += 500
                                if (arr[2] == "मंत्री") pl3 += 0
                                if (arr[3] == "मंत्री") pl4 += 0
                                show2.text = "चोर"
                                show1.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show1.bringToFront()
                               click_chk=0
                               if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                   val intent = Intent(this, congrats_show::class.java)
                                   startActivity(intent)
                                   finish()
                               }
                            }
                        }
                    }

                    if (arr[2] == "सिपाही") {
                        paper2.bringToFront()
                        paper3.bringToFront()
                        pv2.bringToFront()
                        pv3.bringToFront()

                        paper2.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl2 += 0
                                pl3 += 500
                                if (arr[0] == "मंत्री") pl1 += 800
                                if (arr[3] == "मंत्री") pl4 += 800
                                show2.text = "चोर"
                                show3.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show3.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        paper3.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl2 += 800
                                pl3 += 500
                                if (arr[0] == "मंत्री") pl1 += 0
                                if (arr[3] == "मंत्री") pl4 += 0
                                show2.text = "चोर"
                                show3.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show3.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }

                    if (arr[3] == "सिपाही") {
                        paper2.bringToFront()
                        paper4.bringToFront()
                        pv2.bringToFront()
                        pv4.bringToFront()

                        paper2.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl2 += 0
                                pl4 += 500
                                if (arr[0] == "मंत्री") pl1 += 800
                                if (arr[2] == "मंत्री") pl3 += 800
                                show2.text = "चोर"
                                show4.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show4.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }

                        }
                        paper4.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl2 += 800
                                pl4 += 500
                                if (arr[0] == "मंत्री") pl1 += 0
                                if (arr[2] == "मंत्री") pl3 += 0
                                show2.text = "चोर"
                                show4.text = "सिपाही"

                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show4.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }

                if (arr[3] == "चोर") {
                    if (arr[0] == "सिपाही") {
                        paper1.bringToFront()
                        paper4.bringToFront()
                        pv1.bringToFront()
                        pv4.bringToFront()

                        paper4.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl4 += 0
                                pl1 += 500
                                if (arr[2] == "मंत्री") pl3 += 800
                                if (arr[1] == "मंत्री") pl2 += 800
                                show4.text = "चोर"
                                show1.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show1.bringToFront()
                                show4.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                        paper1.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl4 += 800
                                pl1 += 500
                                if (arr[2] == "मंत्री") pl3 += 0
                                if (arr[1] == "मंत्री") pl2 += 0
                                show4.text = "चोर"
                                show1.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show4.bringToFront()
                                show1.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }

                    if (arr[2] == "सिपाही") {
                        paper4.bringToFront()
                        paper3.bringToFront()
                        pv4.bringToFront()
                        pv3.bringToFront()

                        paper4.setOnClickListener {
                           if(click_chk==1) {
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl4 += 0
                                pl3 += 500
                                if (arr[0] == "मंत्री") pl1 += 800
                                if (arr[1] == "मंत्री") pl2 += 800
                                show4.text = "चोर"
                                show3.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show4.bringToFront()
                                show3.bringToFront()
                               click_chk=0
                               if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                   val intent = Intent(this, congrats_show::class.java)
                                   startActivity(intent)
                                   finish()
                               }
                            }
                        }
                        paper3.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl4 += 800
                                pl3 += 500
                                if (arr[0] == "मंत्री") pl1 += 0
                                if (arr[1] == "मंत्री") pl2 += 0
                                show4.text = "चोर"
                                show3.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show4.bringToFront()
                                show3.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }

                    if (arr[1] == "सिपाही") {
                        paper2.bringToFront()
                        paper4.bringToFront()
                        pv2.bringToFront()
                        pv4.bringToFront()

                        paper4.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "सही चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl4 += 0
                                pl2 += 500
                                if (arr[0] == "मंत्री") pl1 += 800
                                if (arr[2] == "मंत्री") pl3 += 800
                                show4.text = "चोर"
                                show2.text = "सिपाही"
                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show4.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }

                        }
                        paper2.setOnClickListener {
                            if(click_chk==1){
                                Toast.makeText(
                                    this@PlayGroundActivity,
                                    "गलत चुनाव",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                pl4 += 800
                                pl2 += 500
                                if (arr[0] == "मंत्री") pl1 += 0
                                if (arr[2] == "मंत्री") pl3 += 0
                                show4.text = "चोर"
                                show2.text = "सिपाही"

                                pv1.setText("$chk1 $pl1")
                                pv2.setText("$chk2 $pl2")
                                pv3.setText("$chk3 $pl3")
                                pv4.setText("$chk4 $pl4")
                                show2.bringToFront()
                                show4.bringToFront()
                                click_chk=0
                                if(pl1>=10000 || pl2>=10000 || pl3>=10000 || pl4>=10000) {
                                    val intent = Intent(this, congrats_show::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(
                    this, "राजा :- मंत्री मंत्री।\n" +
                            "\n" +
                            "मंत्री :-  जी हुजूर..\n" +
                            "\n" +
                            "राजा :-  $x_ और $y_ में से चोर का पता लगाओ।", Toast.LENGTH_SHORT
                ).show()

            }


        }

    }
}