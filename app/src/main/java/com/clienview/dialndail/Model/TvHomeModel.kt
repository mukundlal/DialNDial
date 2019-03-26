package com.clienview.dialndail.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TvHomeModel {
    @SerializedName("pk_int_attribute_id")
    @Expose
    var pkIntAttributeId: String? = null
    @SerializedName("txt_attribute_name")
    @Expose
    var txtAttributeName: String? = null
    @SerializedName("fk_int_gallery_id")
    @Expose
    var fkIntGalleryId: String? = null
    @SerializedName("txt_attribute_notice")
    @Expose
    var txtAttributeNotice: String? = null
    @SerializedName("fk_int_attribute_id")
    @Expose
    var fkIntAttributeId: String? = null
    @SerializedName("pk_int_gallery_id")
    @Expose
    var pkIntGalleryId: String? = null
    @SerializedName("txt_gallery_name")
    @Expose
    var txtGalleryName: String? = null
    @SerializedName("fk_int_gallery_category_id")
    @Expose
    var fkIntGalleryCategoryId: String? = null
    @SerializedName("txt_gallery_priority")
    @Expose
    var txtGalleryPriority: Any? = null
}
