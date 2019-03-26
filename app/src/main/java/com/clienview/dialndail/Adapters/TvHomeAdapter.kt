package com.clienview.dialndail.Adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.clienview.dialndail.MediaLangActivity
import com.clienview.dialndail.Model.TvHomeModel
import com.clienview.dialndail.R
import com.clienview.dialndail.Utils.PublicUrls
import com.squareup.picasso.Picasso

import java.util.ArrayList


class TvHomeAdapter(internal var context: Context, models: List<TvHomeModel>) :
    RecyclerView.Adapter<TvHomeAdapter.ViewHolder>() {
    internal var models: List<TvHomeModel> = ArrayList()
    internal var id: String? = null

    init {
        this.models = models
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvHomeAdapter.ViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.allcategoriesitem, null)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: TvHomeAdapter.ViewHolder, position: Int) {
        holder.name.text = models[position].txtAttributeName
        id = models[position].pkIntAttributeId

        val img = models[position].txtGalleryName
        val url = PublicUrls.imurl+ img !!
        Log.e("aewfrghtya", img)
        Picasso.get().load(url).into(holder.image)

    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var cardView: CardView
        internal var image: ImageView
        internal var name: TextView

        init {
            cardView = v.findViewById<View>(R.id.show_titile) as CardView
            image = v.findViewById<View>(R.id.allCatImg) as ImageView
            name = v.findViewById<View>(R.id.allCatText) as TextView

            cardView.setOnClickListener {
                context.startActivity(
                    Intent(context, MediaLangActivity::class.java).putExtra(
                        "id",
                        models[adapterPosition].pkIntAttributeId
                    ).putExtra("name", models[adapterPosition].txtAttributeName)
                )
            }


        }
    }
}



