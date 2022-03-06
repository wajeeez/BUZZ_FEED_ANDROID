package com.example.gallery.kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toolbar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.gallery.R

class SpecificNews : AppCompatActivity() {

    lateinit var ref: SwipeRefreshLayout

    lateinit var wv:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_news)
        ref=findViewById(R.id.swp)





        wv=findViewById(R.id.wv)
        var url = intent.getStringExtra("url") as String

        ref.setOnRefreshListener {
            ref.isRefreshing=true
            wv.loadUrl(url)
            ref.isRefreshing=false

        }
        wv.loadUrl(url)
        ref.isRefreshing=false

    }

    override fun onBackPressed() {
        this.finish()

    }
}
