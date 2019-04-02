package com.clienview.dialndail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.clienview.dialndail.Adapters.AllCategroriesAdapter
import com.clienview.dialndail.Adapters.ImageSwipeAdapter
import com.clienview.dialndail.Adapters.PopularCategoriesAdapter
import com.clienview.dialndail.Adapters.ShopNowAdapter
import com.clienview.dialndail.Model.*
import com.clienview.dialndail.Utils.PublicUrls
import com.clienview.dialndail.WebUrls.Retrofit
import com.clienview.dialndail.WebUrls.ServiceGenerator
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*
import retrofit2.Call
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var bannerAdsList=ArrayList<AddBanerModel>()
    var addImage=ArrayList<AddImageModel>()
    var allCatgryList=ArrayList<AllCategoriesModel>()
    var popularCatArray=ArrayList<AllCategoryArrayModel>()
    var allCategoryArray=ArrayList<AllCategoryArrayModel>()
    var shopNowArray=ArrayList<ShopeNowModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)



        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        addValues()
        callAddViewApi()
        callAllCategoryAdapter()
        callAllSingleAd()
    }

    private fun addValues() {



    }
    private fun callAllSingleAd() {

        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java,PublicUrls.url)
        val call = jsonPostService.addimage()
        call.enqueue(object : retrofit2.Callback<ArrayList<AddImageModel>> {
            override fun onFailure(call: Call<ArrayList<AddImageModel>>, t: Throwable) {


                Log.e("resp", "${t.message}")

            }

            override fun onResponse(
                call: Call<ArrayList<AddImageModel>>,
                response: Response<ArrayList<AddImageModel>>
            ) {
                addImage=response.body()!!
                Picasso.get().load(PublicUrls.imurl+addImage[0].image).into(singleAddView)

            }
        })
    }
    private fun callAllCategoryAdapter() {

        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java,PublicUrls.url)
        val call = jsonPostService.allcategory()
        call.enqueue(object : retrofit2.Callback<ArrayList<AllCategoriesModel>> {
            override fun onFailure(call: Call<ArrayList<AllCategoriesModel>>, t: Throwable) {


                Log.e("resp", "${t.message}")

            }

            override fun onResponse(
                call: Call<ArrayList<AllCategoriesModel>>,
                response: Response<ArrayList<AllCategoriesModel>>
            ) {
                allCatgryList=response.body()!!
                for (a in allCatgryList){
                    Log.e("log","${a.id},${a.image},${a.popular}")

                    if (a.popular=="1"){

                        popularCatArray.add(AllCategoryArrayModel(a.id!!,a.name!!,a.image!!))
                    }else{

                        allCategoryArray.add(AllCategoryArrayModel(a.id!!,a.name!!,a.image!!))
                    }
                }
                if (popularCatArray.size==0){
                    popularCatRv.visibility=View.GONE
                    shopNowBtn.visibility=View.GONE
                    shopeNowRv.visibility=View.GONE
                }
                initViews()
            }
        })
    }
    private fun callAddViewApi() {

        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java,PublicUrls.url)
       val parms=HashMap<String,String>()
        parms.put("id","40")
        val call = jsonPostService.banner(parms)
        call.enqueue(object : retrofit2.Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e("resp", "${t.message}")
            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                Log.e("resp", "${response.body().toString()}")
            }
//            override fun onFailure(call: Call<ArrayList<AddBanerModel>>, t: Throwable) {
//
//
//                Log.e("resp", "${t.message}")
//
//            }

//            override fun onResponse(
//                call: Call<ArrayList<AddBanerModel>>,
//                response: Response<ArrayList<AddBanerModel>>
//            ) {
//
//                bannerAdsList=response.body()!!
//                val timmer= Timer()
//                bannerAddsViewPager.adapter=ImageSwipeAdapter(applicationContext,bannerAdsList)
//                tabselector.setupWithViewPager(bannerAddsViewPager,true)
//                timmer.scheduleAtFixedRate(Swiping(this@Home,bannerAddsViewPager,bannerAdsList),2000,3000)
//
//            }




        })
    }

    private fun initViews() {
        popularCatRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        shopeNowRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        allCategoriesOneRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        allCategoriesTwoRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        allCategoriesThreeRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        popularCatRv.adapter=PopularCategoriesAdapter(applicationContext,popularCatArray)
        shopeNowRv.adapter=ShopNowAdapter(applicationContext,shopNowArray)
        allCategoriesOneRv.adapter=AllCategroriesAdapter(applicationContext,allCategoryArray)
        allCategoriesTwoRv.adapter=AllCategroriesAdapter(applicationContext,allCategoryArray)
        allCategoriesThreeRv.adapter=AllCategroriesAdapter(applicationContext,allCategoryArray)


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
         //   R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_offers -> {
                startActivity(Intent(this@Home,OffersActivity::class.java))

            }
            R.id.nav_media -> {

                startActivity(Intent(this@Home,MediaMainActivity::class.java))
            }
            R.id.nav_shope -> {
                startActivity(Intent(this@Home,ShopeActivity::class.java))

            }
            R.id.nav_share -> {

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    class Swiping(val context:Activity, val viewpager: ViewPager, val bannerlist: ArrayList<AddBanerModel>) :TimerTask(){
        override fun run() {
           context. runOnUiThread {
                if(viewpager.currentItem<bannerlist.size-1){
                    viewpager.currentItem=viewpager.currentItem+1
                }else{
                    viewpager.currentItem=0
                }

            }
        }
    }
}
