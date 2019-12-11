package com.arundhati.androidcleanarchitectureboilerplate.app.extensions

import android.content.Context
import android.graphics.PorterDuff
import android.net.ConnectivityManager
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Context.toast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.toast(@StringRes stringId: Int){
    toast(getString(stringId))
}

fun Context.screenWidth() = this.resources.displayMetrics.widthPixels
fun Context.screenHeight() = this.resources.displayMetrics.heightPixels

fun Context.inflate(@LayoutRes resId: Int, parent: ViewGroup?): View{
    return LayoutInflater.from(this).inflate(resId, parent, false)
}

fun Context?.isOnline(): Boolean {
    this?.apply {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        return cm?.activeNetworkInfo?.isConnected?:false
    }
    return false
}

fun Context.getPxInDp(px: Int): Int {
    val displayMetrics = resources.displayMetrics
    return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}

fun Context.getPxFromDp(dp: Float) = TypedValue
    .applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

fun Context.getDrawableRes(@DrawableRes drawableRes: Int) = ContextCompat.getDrawable(this, drawableRes)
fun Context.getColorRes(@ColorRes colorRes: Int) = ContextCompat.getColor(this, colorRes)
fun Context.getStringRes(@StringRes stringRes: Int) = resources.getString(stringRes)
fun Context.getFontRes(@FontRes res: Int) = ResourcesCompat.getFont(this, res)
fun Context?.getIntegerRes(@IntegerRes resId: Int) = this?.resources?.getInteger(resId)?.toLong()?:0
fun Context.getDrawableResWithColor(@DrawableRes drawableRes: Int, @ColorRes color: Int) =
    this.getDrawableRes(drawableRes)?.apply {
        setColorFilter(this@getDrawableResWithColor.getColorRes(color), PorterDuff.Mode.SRC_IN)
    }

