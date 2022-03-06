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


class home_frag : Fragment() {

    lateinit var ref:SwipeRefreshLayout
    lateinit var rv1:RecyclerView
    lateinit var adapter: Adapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v1: View = inflater.inflate(R.layout.home_frag,null)
        rv1 = v1.findViewById(R.id.RV1)

        ref=v1.findViewById(R.id.srf)
        ref.setOnRefreshListener {
            getnews()
        }
        getnews()


        return v1
    }

    private fun getnews() {
        ref.isRefreshing=true
        val news: Call<News> = NewsService.newsInstance.getArynews()
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {

                val news = response.body()
                if(news!=null){
                    Log.d("WAJEEEZ",news.toString())
                    adapter = Adapter(requireContext(),news.articles)

                    rv1.layoutManager= LinearLayoutManager(activity)
                    rv1.adapter=adapter
                    ref.isRefreshing=false
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                ref.isRefreshing=false
                Log.d("WAJEEEZ","Errors in Fetching News ",t)
            }

        })
    }



}