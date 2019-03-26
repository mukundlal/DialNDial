package com.clienview.dialndail.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Zaam on 04-06-2018.
 */

class ShopModel {
    @SerializedName("directories")
    @Expose
    var directories: List<Directory>? = null

}
