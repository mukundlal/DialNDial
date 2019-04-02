package com.clienview.dialndail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.clienview.dialndail.Adapters.OffersAdapter
import com.clienview.dialndail.Model.OffersModel
import kotlinx.android.synthetic.main.activity_offers.*

class OffersActivity : AppCompatActivity() {
    private val offersArrayList=ArrayList<OffersModel>()
    private val tempoffersArrayList=ArrayList<OffersModel>()

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
        tempoffersArrayList.addAll(offersArrayList)

        offersRv.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        offersRv.adapter=OffersAdapter(applicationContext,tempoffersArrayList)
        tabLayout.addTab(tabLayout.newTab().setText("ALL"))
        for (k in 0 until offersArrayList.size) {
            tabLayout.addTab(tabLayout.newTab().setText(offersArrayList[k].ofrredby))
        }
        if (tabLayout.tabCount == 2) {
            tabLayout.tabMode = TabLayout.MODE_FIXED
        } else {
            tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        }
        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {


            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                Log.e("position",""+p0!!.position)
                tempoffersArrayList.clear()
                if(p0.position==0)
                {
                    tempoffersArrayList.addAll(offersArrayList)
                    offersRv.adapter!!.notifyDataSetChanged()
                }else
                {   tempoffersArrayList.clear()
                    for (w in offersArrayList)
                    {

                        if (w.ofrredby==offersArrayList[p0.position-1].ofrredby)
                        {
                            tempoffersArrayList.add(w)
                        }

                    }
                    offersRv.adapter!!.notifyDataSetChanged()


                }

            }
        })
    }
}
