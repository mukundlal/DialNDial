package com.clienview.dialndail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.clienview.dialndail.Adapters.OffersAdapter
import com.clienview.dialndail.Model.OffersModel
import kotlinx.android.synthetic.main.activity_offers.*

class OffersActivity : AppCompatActivity() {
            val offersArrayList=ArrayList<OffersModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offers)
        iniViews()
    }

    private fun iniViews() {
        offersArrayList.add(OffersModel("1",
            "https://themarquisblogger.files.wordpress.com/2015/12/norton-ad-3.jpg?w=980&h=980&crop=1",
            "Amazone",
            "",
            "30"))
        offersArrayList.add(OffersModel("1",
            "https://www.ralphlauren.fr/on/demandware.static/-/Sites-RalphLauren_EU-Library/default/dwcec447aa/img/201805/05312018-cp-93-limted-edtion/20180531_cp93ltd_c10_grid_eu.jpg",
            "Flipkart",
            "",
            "20"))
        offersArrayList.add(OffersModel("1",
            "http://www.atticpaper.com/prodimages/060812_B/oldgold_bloodhound.jpg",
            "Something",
            "",
            "20"))
        offersArrayList.add(OffersModel("1",
            "https://chocolateplatform.com/wp-content/uploads/2018/08/PR_Survey_Report_7_Aug-1024x1024.jpg",
            "Something",
            "",
            "20"))
        offersArrayList.add(OffersModel("1",
            "http://www.atticpaper.com/prodimages/093010/oldgold_bulldog.jpg",
            "Something",
            "",
            "20"))


        offersRv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        offersRv.adapter=OffersAdapter(applicationContext,offersArrayList)
    }
}
