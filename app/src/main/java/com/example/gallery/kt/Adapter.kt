package com.example.gallery.kt

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery.R
import fragments.Fragments_main
import java.text.DateFormat
import java.util.*

class Adapter(val context:Context,val articles:List<Article>):RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view:View = inflater.inflate(R.layout.item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article: Article =articles[position]
        holder.cv.setOnClickListener(View.OnClickListener {

            val intent=Intent(context, SpecificNews::class.java)
            intent.putExtra("url",article.url)
            context.startActivity(intent)

        })



        holder.newsTitle.text=article.title
        holder.newsdate.text="Published At : " + article.publishedAt
        Glide.with(context).load(article.urlToImage).placeholder(R.drawable.pic2).into(holder.newsImage)



    }

    override fun getItemCount(): Int {
        return articles.size
    }


}

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    var cv = itemView.findViewById<CardView>(R.id.cardView1)
    var newsImage =itemView.findViewById<ImageView>(R.id.imageView)
    var newsTitle =itemView.findViewById<TextView>(R.id.textView)
    var newsdate = itemView.findViewById<TextView>(R.id.textView2)
}
