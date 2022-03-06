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

class science_frag : Fragment() {
    lateinit var ref2: SwipeRefreshLayout
    lateinit var rv2: RecyclerView
    lateinit var adapter: Adapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v2:View = inflater.inflate(R.layout.science_frag,null)

        rv2 = v2.findViewById(R.id.RV2)

        ref2=v2.findViewById(R.id.srf1)
        ref2.setOnRefreshListener {
            getnews()
        }
        getnews()

        return v2

    }
    private fun getnews() {
        ref2.isRefreshing=true
        val news: Call<News> = NewsService.newsInstance.getscience("us","science",1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if(news!=null){
                    Log.d("WAJEEEZ",news.toString())
                    adapter = Adapter(requireContext(),news.articles)

                    rv2.layoutManager= LinearLayoutManager(activity)
                    rv2.adapter=adapter
                    ref2.isRefreshing=false


                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("WAJEEEZ","Errors in Fetching News ",t)
                ref2.isRefreshing=false
            }

        })
    }







}