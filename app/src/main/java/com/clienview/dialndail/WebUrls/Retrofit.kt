package com.clienview.dialndail.WebUrls



import com.clienview.dialndail.Model.DesktopBannerModel
import com.clienview.dialndail.Model.ShopModel
import com.clienview.dialndail.Model.TvHomeModel
import com.clienview.dialndail.Utils.PublicUrls
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface Retrofit {
    @Headers("Accept: application/json", "Content-Type: application/json")

    @FormUrlEncoded
    @POST("desktop_banner")
    fun banner(
        @Field("id") id: String
    ): Call<ArrayList<DesktopBannerModel>>

    @FormUrlEncoded
    @POST("media_list")
    abstract fun medialist(
        @Field("id") id: String
    ): Call<ArrayList<TvHomeModel>>

    @FormUrlEncoded
    @POST("directories")
    abstract fun list_shop(
        @Field("id") id: String,
        @Field("location") loc: String
    ): Call<ShopModel>




//    @FormUrlEncoded
//    @POST("directorie_list")
//    abstract fun shop(
//        @Field("id") id: String,
//        @Field("location") loc: String
//    ): Call<List<list_shop_model>>

//    @FormUrlEncoded
//    @POST("Live_Tv")
//    abstract fun media(
//        @Field("id") id: String
//    ): Call<List<Media_Model>>
//
//    @FormUrlEncoded
//    @POST("offer")
//    abstract fun offer(
//        @Field("id") id: String
//    ): Call<List<List_Offer>>

//    @FormUrlEncoded
//    @POST("register")
//    Call<List<SugestionModel>> login(
//            @Field("name") String user,
//            @Field("phone") String phone,
//            @Field("register") String register
//    );

//    @FormUrlEncoded
//    @POST("search")
//    abstract fun suggest(
//        @Field("keyword") keyword: String
//    ): Call<List<SugestionModel>>
//
//    @FormUrlEncoded
//    @POST("search_list")
//    abstract fun suggest_list(
//        @Field("keyword") keyword: String
//    ): Call<List<list_shop_model>>
//
//    @FormUrlEncoded
//    @POST("countrie")
//    abstract fun countie(
//        @Field("id") id: String
//    ): Call<List<Place_Countries_Model>>
//
//    @FormUrlEncoded
//    @POST("list_view")
//    abstract fun state(
//        @Field("id") id: String
//    ): Call<List<Place_State_Model>>
//
//
//    @FormUrlEncoded
//    @POST("notification")
//    abstract fun notification(
//        @Field("id") id: String
//    ): Call<List<NotificationModel>>
//
//
//
//
//    @FormUrlEncoded
//    @POST("video_banner")
//    abstract fun vid_banner(
//        @Field("id") id: String
//    ): Call<List<video_banner_model>>


}
