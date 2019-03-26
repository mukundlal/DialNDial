package com.clienview.dialndail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.clienview.dialndail.Adapters.MediaAdapter
import com.clienview.dialndail.Model.TvHomeModel
import com.clienview.dialndail.Utils.PublicUrls
import com.clienview.dialndail.WebUrls.Retrofit
import com.clienview.dialndail.WebUrls.ServiceGenerator

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.ArrayList

class MediaActivity : AppCompatActivity() {

    internal lateinit var mediaAdapter: MediaAdapter

    internal var models: List<TvHomeModel>? = ArrayList()
    private var recyclerView: RecyclerView? = null
    internal lateinit var shop: TextView
    internal lateinit var id: String
    internal lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_media)
        shop = findViewById<View>(R.id.heading) as TextView
        id = intent.getSerializableExtra("id") as String
        name = intent.getSerializableExtra("name") as String
        //  Toast.makeText(getApplicationContext(), "value"+id,Toast.LENGTH_LONG).show();


        recyclerView = findViewById<View>(R.id.media) as RecyclerView?
        recyclerView!!.layoutManager = GridLayoutManager(applicationContext, 3)


        shop.text = name

        show()
    }

    private fun show() {
        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java, PublicUrls.url)
        val call = jsonPostService.medialist(id)
        call.enqueue(object : Callback<ArrayList<TvHomeModel>> {
            override fun onResponse(call: Call<ArrayList<TvHomeModel>>, response: Response<ArrayList<TvHomeModel>>) {
                models = response.body()

                mediaAdapter = MediaAdapter(applicationContext, models!!)
                recyclerView!!.adapter = mediaAdapter
            }

            override fun onFailure(call: Call<ArrayList<TvHomeModel>>, t: Throwable) {

            }
        })


    }
}
