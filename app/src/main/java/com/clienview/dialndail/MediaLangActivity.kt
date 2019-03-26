package com.clienview.dialndail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.clienview.dialndail.Adapters.MediaLangAdapter
import com.clienview.dialndail.Model.TvHomeModel
import com.clienview.dialndail.Utils.PublicUrls
import com.clienview.dialndail.WebUrls.Retrofit
import com.clienview.dialndail.WebUrls.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.ArrayList

class MediaLangActivity : AppCompatActivity() {
    internal lateinit var id: String
    internal lateinit var name: String
    internal lateinit var recyclerView: RecyclerView
    internal lateinit var media_lang_adapter: MediaLangAdapter
    internal var models: List<TvHomeModel>? = ArrayList()
    internal var shop: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_lang)
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //  shop=(TextView)findViewById(R.id.heading);
        id = intent.getSerializableExtra("id") as String
        name = intent.getSerializableExtra("name") as String
        //Toast.makeText(getApplicationContext(), "value" + id, Toast.LENGTH_LONG).show();
        title = name
        recyclerView = findViewById<RecyclerView>(R.id.mediaa)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)

        show()
    }

    private fun show() {
        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java, PublicUrls.url)
        val call = jsonPostService.medialist(id)
        call.enqueue(object : Callback<ArrayList<TvHomeModel>> {
            override fun onResponse(call: Call<ArrayList<TvHomeModel>>, response: Response<ArrayList<TvHomeModel>>) {
                models = response.body()

                media_lang_adapter = MediaLangAdapter(applicationContext, models!!)
                recyclerView.adapter = media_lang_adapter
            }

            override fun onFailure(call: Call<ArrayList<TvHomeModel>>, t: Throwable) {

            }
        })


    }
}
