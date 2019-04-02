package com.clienview.dialndail.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AllCategoriesModel( @SerializedName("c_id")
                          @Expose
                          var id: String? = null,
                          @SerializedName("c_name")
                          @Expose
                          var name: String? = null,
                          @SerializedName("c_imageurl")
                          @Expose
                          var image: String? = null,
                          @SerializedName("c_popular")
                          @Expose
                          var popular: String? = null
) {
}