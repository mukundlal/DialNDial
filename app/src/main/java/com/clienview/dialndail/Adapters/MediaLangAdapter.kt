package com.clienview.dialndail.Adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.clienview.dialndail.MediaActivity
import com.clienview.dialndail.Model.TvHomeModel
import com.clienview.dialndail.R
import com.clienview.dialndail.Utils.PublicUrls
import com.squareup.picasso.Picasso


import java.util.ArrayList


class MediaLangAdapter(internal var context: Context, models: List<TvHomeModel>) :
    RecyclerView.Adapter<MediaLangAdapter.ViewHolder>() {
    internal var models: List<TvHomeModel> = ArrayList()
    internal var id: String? = null

    init {
        this.models = models
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.media_lang, parent, false)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = models[position].txtAttributeName
        id = models[position].pkIntAttributeId

        val img = models[position].txtGalleryName
        val url = PublicUrls.imurl + img!!
        Picasso.get().load(url).into(holder.image)

    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var cardView: CardView = v.findViewById(R.id.tvshow_titile) as CardView
        internal var image: ImageView = v.findViewById(R.id.tvimage) as ImageView
        internal var name: TextView = v.findViewById(R.id.tvtitle) as TextView

        init {

            cardView.setOnClickListener {
                context.startActivity(
                    Intent(context, MediaActivity::class.java).setFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK
                    ).putExtra("id", models[adapterPosition].pkIntAttributeId).putExtra(
                        "name",
                        models[adapterPosition].txtAttributeName
                    )
                )
            }


        }
    }
}