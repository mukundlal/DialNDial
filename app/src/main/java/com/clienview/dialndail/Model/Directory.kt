package com.clienview.dialndail.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Directory {
    @SerializedName("pk_int_attribute_id")
    @Expose
    var pkIntAttributeId: String? = null
    @SerializedName("txt_gallery_name")
    @Expose
    var txtGalleryName: String? = null
    @SerializedName("txt_attribute_name")
    @Expose
    var txtAttributeName: String? = null
}

