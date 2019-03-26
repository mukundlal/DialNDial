package com.clienview.dialndail.Adapters

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.clienview.dialndail.Adapters.MediaAdapter.ViewHolder

import com.clienview.dialndail.Model.TvHomeModel
import com.clienview.dialndail.R
import com.clienview.dialndail.Utils.PublicUrls

import com.squareup.picasso.Picasso

import java.util.ArrayList


class MediaAdapter(internal var context: Context, models: List<TvHomeModel>) :
    RecyclerView.Adapter<ViewHolder>() {
    internal var models: List<TvHomeModel> = ArrayList()
    internal var id: String? = null
    internal var path: String? = null

    init {
        this.models = models
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.media, null)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.name.setText(models.get(position).getName());

        id = models[position].pkIntAttributeId
        path = models[position].txtAttributeNotice
        val img = models[position].txtGalleryName
        val url = PublicUrls.url + img!!

        Picasso.get().load(url).into(holder.image)

    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class ViewHolder
    // TextView name;

        (v: View) : RecyclerView.ViewHolder(v) {
        internal var cardView: CardView
        internal var image: ImageView

        init {
            cardView = v.findViewById<View>(R.id.show_media) as CardView
            image = v.findViewById<View>(R.id.media_image) as ImageView
            // name=(TextView)v.findViewById(R.id.media_name);ById

            //  cardView=(CardView)v.findViewById(R.id.media_view);

            cardView.setOnClickListener {
                //   context. startActivity(new Intent(context, Youtube_Activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("id",models.get(getAdapterPosition()).getPkIntAttributeId()).putExtra("id",models.get(getAdapterPosition()).getPkIntAttributeId()).putExtra("path",models.get(getAdapterPosition()).getTxtAttributeNotice()));
            }


        }
    }
}

