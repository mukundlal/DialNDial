package com.clienview.dialndail.Adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clienview.dialndail.Model.ShopeNowModel
import com.clienview.dialndail.R
import kotlinx.android.synthetic.main.shopnowitem.view.*


class ShopNowAdapter(
    val applicationContext: Context,
    val shopNowArray: ArrayList<ShopeNowModel>
) :RecyclerView.Adapter<ShopNowAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       val view=LayoutInflater.from(p0.context).inflate(R.layout.shopnowitem,p0,false)

        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return shopNowArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=shopNowArray[position]
        holder.itemname.text=model.title

    }



    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val itemname=itemView.itemsname

    }
}