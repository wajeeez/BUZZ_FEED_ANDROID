package fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.gallery.R
import com.example.gallery.kt.Adapter
import com.example.gallery.kt.News
import com.example.gallery.kt.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class tech_frag : Fragment() {

    lateinit var ref3: SwipeRefreshLayout
    lateinit var rv3: RecyclerView
    lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v3:View = inflater.inflate(R.layout.tech_frag,null)

        rv3 = v3.findViewById(R.id.RV3)


        ref3=v3.findViewById(R.id.srf2)
        ref3.setOnRefreshListener {
            getnews()
        }
        getnews()

        return v3


    }


    private fun getnews() {
        ref3.isRefreshing=true
        val news: Call<News> = NewsService.newsInstance.getscience("us","technology",1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if(news!=null){
                    Log.d("WAJEEEZ",news.toString())
                    adapter = Adapter(requireContext(),news.articles)
                    rv3.layoutManager= LinearLayoutManager(activity)
                    rv3.adapter=adapter
                    ref3.isRefreshing=false
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                ref3.isRefreshing=false
                Log.d("WAJEEEZ","Errors in Fetching News ",t)
            }

        })
    }
}