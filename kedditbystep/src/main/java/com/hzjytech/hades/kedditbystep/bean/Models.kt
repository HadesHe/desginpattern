package com.hzjytech.hades.kedditbystep.bean

import android.os.Parcelable

/**
 * Created by Hades on 2017/12/2.
 */
data class RedditNews{

    val after:String
    val before:String
    val news:List

}

data class RedditNewsItem():ViewType,Parcelable{

}