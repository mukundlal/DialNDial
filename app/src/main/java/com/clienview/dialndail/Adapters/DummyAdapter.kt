package com.clienview.dialndail.Adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clienview.dialndail.R


class DummyAdapter():RecyclerView.Adapter<DummyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       val view=LayoutInflater.from(p0.context).inflate(R.layout.allcategoriesitem,p0,false)

        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }



    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    }
}