package com.clienview.dialndail.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
// "id": "1",
//        "image": "front_adv/org_5c9e35d6dca97.png"
class AddImageModel(
                    @SerializedName("id")
                    @Expose
                    var id: String? = null,
                    @SerializedName("image")
                    @Expose
                    var image: String? = null
)
