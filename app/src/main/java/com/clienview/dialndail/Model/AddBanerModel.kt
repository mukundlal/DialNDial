package com.clienview.dialndail.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AddBanerModel(
                    @SerializedName("adv_image")
                    @Expose
                    var adv_image: String? = null
)
