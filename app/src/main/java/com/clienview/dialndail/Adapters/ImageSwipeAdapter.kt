package com.clienview.dialndail.Adapters

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.clienview.dialndail.Model.DesktopBannerModel
import com.clienview.dialndail.Utils.PublicUrls
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList


class ImageSwipeAdapter(val context: Context, val bannerList: ArrayList<DesktopBannerModel>):PagerAdapter() {

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
       return p0==p1
    }

    override fun getCount(): Int {
        return bannerList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView=ImageView(context)
        Picasso.get().load(PublicUrls.imurl+bannerList[position].txtGalleryName)
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