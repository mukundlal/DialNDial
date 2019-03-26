package com.clienview.dialndail.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zaam on 14-06-2018.
 */

public class Media_Model {
    @SerializedName("pk_int_attribute_id")
    @Expose
    private String pkIntAttributeId;
    @SerializedName("txt_attribute_name")
    @Expose
    private String txtAttributeName;
    @SerializedName("fk_int_gallery_id")
    @Expose
    private String fkIntGalleryId;
    @SerializedName("txt_attribute_notice")
    @Expose
    private String txtAttributeNotice;
    @SerializedName("fk_int_attribute_id")
    @Expose
    private String fkIntAttributeId;
    @SerializedName("pk_int_gallery_id")
    @Expose
    private String pkIntGalleryId;
    @SerializedName("txt_gallery_name")
    @Expose
    private String txtGalleryName;
    @SerializedName("fk_int_gallery_category_id")
    @Expose
    private String fkIntGalleryCategoryId;
    @SerializedName("txt_gallery_priority")
    @Expose
    private Object txtGalleryPriority;

    public String getPkIntAttributeId() {
        return pkIntAttributeId;
    }

    public void setPkIntAttributeId(String pkIntAttributeId) {
        this.pkIntAttributeId = pkIntAttributeId;
    }

    public String getTxtAttributeName() {
        return txtAttributeName;
    }

    public void setTxtAttributeName(String txtAttributeName) {
        this.txtAttributeName = txtAttributeName;
    }

    public String getFkIntGalleryId() {
        return fkIntGalleryId;
    }

    public void setFkIntGalleryId(String fkIntGalleryId) {
        this.fkIntGalleryId = fkIntGalleryId;
    }

    public String getTxtAttributeNotice() {
        return txtAttributeNotice;
    }

    public void setTxtAttributeNotice(String txtAttributeNotice) {
        this.txtAttributeNotice = txtAttributeNotice;
    }

    public String getFkIntAttributeId() {
        return fkIntAttributeId;
    }

    public void setFkIntAttributeId(String fkIntAttributeId) {
        this.fkIntAttributeId = fkIntAttributeId;
    }

    public String getPkIntGalleryId() {
        return pkIntGalleryId;
    }

    public void setPkIntGalleryId(String pkIntGalleryId) {
        this.pkIntGalleryId = pkIntGalleryId;
    }

    public String getTxtGalleryName() {
        return txtGalleryName;
    }

    public void setTxtGalleryName(String txtGalleryName) {
        this.txtGalleryName = txtGalleryName;
    }

    public String getFkIntGalleryCategoryId() {
        return fkIntGalleryCategoryId;
    }

    public void setFkIntGalleryCategoryId(String fkIntGalleryCategoryId) {
        this.fkIntGalleryCategoryId = fkIntGalleryCategoryId;
    }

    public Object getTxtGalleryPriority() {
        return txtGalleryPriority;
    }

    public void setTxtGalleryPriority(Object txtGalleryPriority) {
        this.txtGalleryPriority = txtGalleryPriority;
    }
}
