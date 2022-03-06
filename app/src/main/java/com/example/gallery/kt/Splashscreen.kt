package com.example.gallery.kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.gallery.R
import fragments.Fragments_main

class Splashscreen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        handler = Handler()
        handler.postDelayed({

            val intent= Intent(this, Fragments_main::class.java)
            startActivity(intent)
            finish()
        },1500)
    }
}