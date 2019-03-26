package com.clienview.dialndail.Utils
import android.content.Context


class SharedPreferenceUserApp(context: Context) {

    private val SHARED_PREFERENCE_NAME="DailNDail"
    private val SHARED_PREFERENCE_USER_ID="id"
    private val SHARED_PREFERENCE_USER_NAME="name"
    private val SHARED_PREFERENCE_MOBILE="mobile"
    private val SHARED_PREFERENCE_EMAIL="email"


    val shared_preference= context.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE)!!
    
    fun getUserImage():String?{
        return shared_preference.getString("imgUrl","")
    }

    fun setUserImage(userId:String){
        val editor=shared_preference.edit()
        editor.putString("imgUrl",userId)
        editor.apply()
    }
    fun getUserId():String?{
        return shared_preference.getString(SHARED_PREFERENCE_USER_ID,"")
    }

    fun setUserId(userId:String){
        val editor=shared_preference.edit()
        editor.putString(SHARED_PREFERENCE_USER_ID,userId)
        editor.apply()
    }
    fun getUserName():String?{
        return shared_preference.getString(SHARED_PREFERENCE_USER_NAME,"")
    }

    fun setUserName(userName:String){
        val editor=shared_preference.edit()
        editor.putString(SHARED_PREFERENCE_USER_NAME,userName)
        editor.apply()
    }
    fun getUserMobile():String?{
        return shared_preference.getString(SHARED_PREFERENCE_MOBILE,"")
    }

    fun setUserMobile(userName:String){
        val editor=shared_preference.edit()
        editor.putString(SHARED_PREFERENCE_MOBILE,userName)
        editor.apply()
    }
    fun getUserEmail():String?{
        return shared_preference.getString(SHARED_PREFERENCE_EMAIL,"")
    }

    fun setUserEmail(userName:String){
        val editor=shared_preference.edit()
        editor.putString(SHARED_PREFERENCE_EMAIL,userName)
        editor.apply()
    }

    fun getLoginStatus():Boolean{
        return shared_preference.getBoolean("IS_LOGED",false)
    }

    fun setLoginStatus(isLoged:Boolean){
        val editor=shared_preference.edit()
        editor.putBoolean("IS_LOGED",isLoged)
        editor.apply()
    }

}