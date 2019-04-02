package com.clienview.dialndail.Adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.clienview.dialndail.Model.AddBanerModel
import com.clienview.dialndail.Utils.PublicUrls
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList


class ImageSwipeAdapter(val context: Context, val bannerList: ArrayList<AddBanerModel>):PagerAdapter() {

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
       return p0==p1
    }

    override fun getCount(): Int {
        return bannerList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView=ImageView(context)
        Log.e("image url", PublicUrls.imurl+bannerList[position].adv_image)
        Picasso.get().load(PublicUrls.imurl+bannerList[position].adv_image)
            .fit()
            .centerCrop()
            .into(imageView)
        container.addView(imageView)
        return imageView


    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
       container.removeView(`object`as View)
    }
}