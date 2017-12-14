package com.hzjytech.hades.kotlinlearn

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.widget.EditText
import android.widget.TextView

/**
 * Created by Hades on 2017/12/14.
 */
internal inline fun EditText.validateWith(
        passIcon:Drawable? = ContextCompat.getDrawable(context , R.drawable.ic_pass),
        failIcon:Drawable? = ContextCompat.getDrawable(context , R.drawable.ic_fail),
        validator: TextView.() -> Boolean): Boolean{
    setCompoundDrawablesWithIntrinsicBounds(null,null,
            if(validator())passIcon else failIcon,null)
    return validator()

}