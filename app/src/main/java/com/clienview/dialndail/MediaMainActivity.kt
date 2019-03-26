package com.clienview.dialndail

import android.app.PendingIntent.getActivity
import android.app.ProgressDialog.show
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.clienview.dialndail.Adapters.TvHomeAdapter
import com.clienview.dialndail.Model.TvHomeModel
import com.clienview.dialndail.Utils.PublicUrls
import com.clienview.dialndail.WebUrls.Retrofit
import com.clienview.dialndail.WebUrls.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MediaMainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    internal lateinit var progressBar: ProgressBar
    var models =  ArrayList<TvHomeModel>()


    internal lateinit var tvHomeAdapter: TvHomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_main)
        recyclerView = findViewById(R.id.tvrecycleview)
        progressBar = findViewById(R.id.progressbar)
        recyclerView!!.layoutManager = GridLayoutManager(applicationContext, 3)
        models.clear()
        progressBar.visibility = View.VISIBLE
        if (!isConnected(applicationContext))
            buildDialog(applicationContext).show()
        else {

            show()

        }
    }

    private fun show() {
        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java, PublicUrls.url)
        val call = jsonPostService.medialist("429")
        call.enqueue(object : Callback<ArrayList<TvHomeModel>> {
            override fun onResponse(call: Call<ArrayList<TvHomeModel>>, response: Response<ArrayList<TvHomeModel>>) {

                models = response.body()!!
                progressBar.visibility = View.GONE
                tvHomeAdapter = TvHomeAdapter(applicationContext, models)
                recyclerView!!.adapter = tvHomeAdapter
            }

            override fun onFailure(call: Call<ArrayList<TvHomeModel>>, t: Throwable) {

            }
        })


    }

    fun isConnected(context: Context?): Boolean {

        val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netinfo = cm.activeNetworkInfo

        if (netinfo != null && netinfo.isConnectedOrConnecting) {
            val wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            val mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

            return mobile != null && mobile.isConnectedOrConnecting || wifi != null && wifi.isConnectedOrConnecting
        } else
            return false
    }


    fun buildDialog(c: Context?): AlertDialog.Builder {

        val builder = AlertDialog.Builder(c!!)
        builder.setTitle("No Internet Connection")
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit")

        builder.setPositiveButton("Ok") { dialog, which -> }

        return builder

    }
}
