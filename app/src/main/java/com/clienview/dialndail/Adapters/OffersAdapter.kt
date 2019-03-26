package com.clienview.dialndail.Adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clienview.dialndail.Model.OffersModel
import com.clienview.dialndail.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.offeritem.view.*


class OffersAdapter(
    val applicationContext: Context,
    val offersArrayList: ArrayList<OffersModel>
) :RecyclerView.Adapter<OffersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       val view=LayoutInflater.from(p0.context).inflate(R.layout.offeritem,p0,false)

        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return offersArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model=offersArrayList[position]
        Picasso.get().load(model.offrimglink).into(holder.ofrImg)
        holder.oferText.text=model.ofrredby
        holder.ofrDaysLeft.text=model.daysleft

    }



    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val ofrImg=itemView.ofrImg
        val oferText= itemView.ofByName
        val ofrDtls=itemView.ofDetailText
        val ofrDaysLeft=itemView.ofDaysLeft
        val ofrOwnerImg=itemView.ofrOwnerImg

    }
}