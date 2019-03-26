package com.clienview.dialndail

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.clienview.dialndail.Model.Directory
import com.clienview.dialndail.Model.ShopModel
import com.clienview.dialndail.Utils.PublicUrls
import com.clienview.dialndail.WebUrls.Retrofit
import com.clienview.dialndail.WebUrls.ServiceGenerator

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.ArrayList

class ShopeActivity : AppCompatActivity() {

    internal var models: List<Directory>? = ArrayList()
    internal var shop_model: ShopModel? = null
    internal var shop: TextView? = null
    internal var id: String? = null
    internal lateinit var name: String
    internal var im: String? = null
    internal var searchname: String? = null
    internal lateinit var listView: ListView
    internal lateinit var image: ImageView
    internal lateinit var names: TextView
    internal lateinit var cardView: CardView
    internal var cityid: String? = null
    internal var conid: String? = null
    internal lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shope_)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        //Toolbar toolbars = (Toolbar) findViewById(R.id.toolbarshop);

        progressBar = findViewById<View>(R.id.progressbar) as ProgressBar
        //  shop=(TextView)findViewById(R.id.shopheading);
//        id = intent.getSerializableExtra("id","") as String
//
//        name = intent.getSerializableExtra("name") as String
        id="1"
        name="Shope"
        title = name
        // Toast.makeText(getApplicationContext(), "value"+name, Toast.LENGTH_LONG).show();
        val shared = getSharedPreferences("dialanddial", Context.MODE_PRIVATE)
        val cityname = shared.getString("cityname", "")
        cityid = shared.getString("cityid", "")
        conid = shared.getString("conid", "")
        // Toast.makeText(getApplicationContext(), "valuesss"+conid, Toast.LENGTH_LONG).show();
        listView = findViewById<View>(R.id.listview) as ListView

        //shop.setText(name);
        progressBar.visibility = View.VISIBLE
        if (!isConnected(this@ShopeActivity))
            buildDialog(this@ShopeActivity).show()
        else {
            show()
        }
        if (id == "") {
            //startActivity(new Intent(getApplicationContext(), ToastActivity.class));
            finish()
        }


    }


    fun isConnected(context: Context): Boolean {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netinfo = cm.activeNetworkInfo

        if (netinfo != null && netinfo.isConnectedOrConnecting) {
            val wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            val mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)

            return mobile != null && mobile.isConnectedOrConnecting || wifi != null && wifi.isConnectedOrConnecting
        } else
            return false
    }


    fun buildDialog(c: Context): AlertDialog.Builder {

        val builder = AlertDialog.Builder(c)
        builder.setTitle("No Internet Connection")
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit")

        builder.setPositiveButton("Ok") { dialog, which -> finish() }

        return builder

    }

    private fun show() {
        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java, PublicUrls.url)
        val call = jsonPostService.list_shop(id!!, cityid!!)
        call.enqueue(object : Callback<ShopModel> {
            override fun onResponse(call: Call<ShopModel>, response: Response<ShopModel>) {
                try {
                    shop_model = response.body()
                    //  Log.e("gfhjgkhf111111",new Gson().toJson(shop_model));
                    progressBar.visibility = View.GONE
                    models = shop_model!!.directories
                    val customAdapt = CustomAdapter()
                    listView.adapter = customAdapt
                } catch (e: Exception) {

                }

                //  shopActivityAdapter=new shop_activity_adapter(Shope_Activity.this,models);

                //recyclerView.setAdapter(shopActivityAdapter);
            }

            override fun onFailure(call: Call<ShopModel>, t: Throwable) {
                Log.e("err7or", t.message)
            }
        })


    }


    inner class CustomAdapter : BaseAdapter() {


        override fun getCount(): Int {
            return models!!.size
        }

        override fun getItem(i: Int): Any? {
            return null
        }

        override fun getItemId(i: Int): Long {
            return 0
        }

        override fun getView(i: Int, view: View, viewGroup: ViewGroup): View {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val v = inflater.inflate(R.layout.showshopes, null)
            cardView = v.findViewById(R.id.show_shopes)
            image = v.findViewById(R.id.image)
            names = v.findViewById(R.id.title)

            try {


                im = models!![i].txtGalleryName


                id = models!![i].pkIntAttributeId

                val url = PublicUrls.imurl + im!!
                Picasso.get().load(url).into(image)


                names.text = models!![i].txtAttributeName
            } catch (e: Exception) {

            }




            return v

        }
    }

    override fun onResume() {
        super.onResume()

    }


}
