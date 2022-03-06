package fragments

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.gallery.R
import com.example.gallery.kt.Adapter
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class Fragments_main : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    var isconnected:Boolean = false
    lateinit var cm:ConnectivityManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_main)

        toolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(toolbar)
        tabLayout = findViewById(R.id.tabLayout)
        isconnected=checkconnection()
        if(isconnected){

        }else{

            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_LONG).show()
        }
        setUI()
    }
   fun setUI(){

        val viewpager : ViewPager = findViewById(R.id.fragmentcontainer)
        val adapter = pageradapter(supportFragmentManager)
        adapter.addFragment(home_frag(),"HOME")
        adapter.addFragment(science_frag(),"SCIENCE")
        adapter.addFragment(tech_frag(),"TECHNOLOGY")
        viewpager.adapter=adapter
        tabLayout.setupWithViewPager(viewpager)


    }



   fun checkconnection():Boolean{
           cm= applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
           val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
           val conn:Boolean = activeNetwork?.isConnectedOrConnecting == true
       return conn
   }






}