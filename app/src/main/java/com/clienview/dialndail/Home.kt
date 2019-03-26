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
import android.view.Menu
import android.view.MenuItem
import com.clienview.dialndail.Adapters.AllCategroriesAdapter
import com.clienview.dialndail.Adapters.ImageSwipeAdapter
import com.clienview.dialndail.Adapters.PopularCategoriesAdapter
import com.clienview.dialndail.Adapters.ShopNowAdapter
import com.clienview.dialndail.Model.AllCategoriesModel
import com.clienview.dialndail.Model.DesktopBannerModel
import com.clienview.dialndail.Model.PopularCategoriesModel
import com.clienview.dialndail.Model.ShopeNowModel
import com.clienview.dialndail.Utils.PublicUrls
import com.clienview.dialndail.WebUrls.Retrofit
import com.clienview.dialndail.WebUrls.ServiceGenerator
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.content_home.*
import retrofit2.Call
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var bannerAdsList=ArrayList<DesktopBannerModel>()
    var allCatgryList=ArrayList<AllCategoriesModel>()
    var popularCatArray=ArrayList<PopularCategoriesModel>()
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
        initViews()
        callAddViewApi()
    }

    private fun addValues() {
       allCatgryList.add(AllCategoriesModel("1","https://png.pngtree.com/svg/20161113/ef1b24279e.png","Online"))
        allCatgryList.add(AllCategoriesModel("1","http://www.stickpng.com/assets/images/58e91965eb97430e819064f5.png","Online"))
        allCatgryList.add(AllCategoriesModel("1","http://aux.iconspalace.com/uploads/chat-icon-256-1480184508.png","Online"))
        allCatgryList.add(AllCategoriesModel("1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeUxmrC179LWZsY1GVQGht1IzcYBFb0nB2jOcxm4HHwSNz5gNDnA","Online"))
        allCatgryList.add(AllCategoriesModel("1","https://memegene.net/sites/default/files/wallpaper/camera-icons/445672/camera-icons-round-445672-844260.png","Online"))
        allCatgryList.add(AllCategoriesModel("1","https://img.xda-cdn.com/W5Nf7RvfUR0y0ZnKxPEL2qZthos=/http%3A%2F%2Fforum.xda-developers.com%2Fattachment.php%3Fattachmentid%3D2822556%26stc%3D1%26d%3D1403977531","Online"))
        allCatgryList.add(AllCategoriesModel("1","http://www.myiconfinder.com/uploads/iconsets/256-256-4879bd68332575ee287b47c870258beb.png","Online"))
        allCatgryList.add(AllCategoriesModel("1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSY9fS9dIT6d2N3WvTtdmFWIzcMhwvYrV9pc6O2cdMqqEGZnkPT","Online"))
        allCatgryList.add(AllCategoriesModel("1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCb4TNE3i9jZL6gMmYK4rZ_Xw6EWIbk-VFnVielOjzZPOwh3WS","Online"))
        allCatgryList.add(AllCategoriesModel("1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRs4f1sLWjQAhf7cBdHbsIL3hd_TiHy2LjPniDYGmZkOuPWnn4Jgw","Online"))


        shopNowArray.add(ShopeNowModel("1","Amazon"))
        shopNowArray.add(ShopeNowModel("1","Flipkart"))
        shopNowArray.add(ShopeNowModel("1","Jabong"))
        shopNowArray.add(ShopeNowModel("1","Minthra"))
        shopNowArray.add(ShopeNowModel("1","Swiggy"))
        shopNowArray.add(ShopeNowModel("1","AJIO"))
        shopNowArray.add(ShopeNowModel("1","GadgetWala"))

        popularCatArray.add(PopularCategoriesModel("1","http://aux.iconspalace.com/uploads/amazon-payment-icon-256.png","Amazone"))
        popularCatArray.add(PopularCategoriesModel("1","https://banner2.kisspng.com/20180623/hcw/kisspng-flipkart-business-e-commerce-retail-sales-5b2dec230f35c8.8488817015297362270623.jpg","Flipkart"))
        popularCatArray.add(PopularCategoriesModel("1","https://paulwriter.com/wp-content/uploads/2018/05/myntra.jpg","Mynthra"))
        popularCatArray.add(PopularCategoriesModel("1","http://www.financebuddy.in/wp-content/uploads/2016/12/ebay-shopping-site.png","Ebay"))
        popularCatArray.add(PopularCategoriesModel("1","https://cdn.iconscout.com/icon/free/png-256/snapdeal-282408.png","SnapDeal"))
        popularCatArray.add(PopularCategoriesModel("1","https://i0.wp.com/www.indiaretailing.com/wp-content/uploads/2008/12/Home-shop18.jpg?zoom=2.625&resize=392%2C230&ssl=1","HomeSHope18"))








    }

    private fun callAddViewApi() {

        val jsonPostService = ServiceGenerator.createService(Retrofit::class.java,PublicUrls.url)
        val call = jsonPostService.banner("")
        call.enqueue(object : retrofit2.Callback<ArrayList<DesktopBannerModel>> {
            override fun onFailure(call: Call<ArrayList<DesktopBannerModel>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<ArrayList<DesktopBannerModel>>,
                response: Response<ArrayList<DesktopBannerModel>>
            ) {
                bannerAdsList=response.body()!!
                val timmer= Timer()
                bannerAddsViewPager.adapter=ImageSwipeAdapter(applicationContext,bannerAdsList)
                tabselector.setupWithViewPager(bannerAddsViewPager,true)
                timmer.scheduleAtFixedRate(Swiping(this@Home,bannerAddsViewPager,bannerAdsList),2000,3000)


            }


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
        allCategoriesOneRv.adapter=AllCategroriesAdapter(applicationContext,allCatgryList)
        allCategoriesTwoRv.adapter=AllCategroriesAdapter(applicationContext,allCatgryList)
        allCategoriesThreeRv.adapter=AllCategroriesAdapter(applicationContext,allCatgryList)


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
    class Swiping(val context:Activity, val viewpager: ViewPager, val bannerlist: ArrayList<DesktopBannerModel>) :TimerTask(){
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
