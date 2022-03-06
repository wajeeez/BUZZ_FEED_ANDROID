package com.example.gallery.kt

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/everything?q=apple&from=2021-11-06&to=2021-11-06&sortBy=popularity&apiKey=080b67302ee84a42977a1a7ee27545a2
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=080b67302ee84a42977a1a7ee27545a2

const val  BASE_URL ="https://newsapi.org/"
const val API_KEY="080b67302ee84a42977a1a7ee27545a2"

interface NewsInterface {


    @GET("v2/top-headlines?sources=ary-news&apiKey=$API_KEY")
    fun getArynews():Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country:String ,@Query("page")pages:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun gettech(@Query("country") country:String ,@Query("category")cat:String,@Query("page")pages:Int):Call<News>

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getscience(@Query("country") country:String ,@Query("category")cat:String,@Query("page")pages:Int):Call<News>


}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit: Retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance =retrofit.create(NewsInterface::class.java)
    }
}