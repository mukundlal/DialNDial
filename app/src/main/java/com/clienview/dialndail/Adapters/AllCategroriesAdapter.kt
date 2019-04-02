package com.clienview.dialndail.Adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clienview.dialndail.Model.AllCategoryArrayModel
import com.clienview.dialndail.R
import com.clienview.dialndail.Utils.PublicUrls
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.allcategoriesitem.view.*


class AllCategroriesAdapter(
    val applicationContext: Context,
    val allCatgryList: ArrayList<AllCategoryArrayModel>
) :RecyclerView.Adapter<AllCategroriesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       val view=LayoutInflater.from(p0.context).inflate(R.layout.allcategoriesitem,p0,false)

        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return allCatgryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=allCatgryList[position]
        Picasso.get().load(PublicUrls.imurl+model.imageurl).into(holder.allImge)
        holder.allText.text=model.title


    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val allImge=itemView.allCatImg
        val allText=itemView.allCatText

    }
}