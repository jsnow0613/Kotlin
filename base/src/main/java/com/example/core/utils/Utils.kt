package com.example.core.utils


import android.util.TypedValue
import kotlin.jvm.JvmOverloads
import android.widget.Toast
import com.example.core.BaseApplication
import android.content.res.Resources

object Utils {
    private val displayMetrics = Resources.getSystem().displayMetrics
    fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
    }

    @JvmOverloads
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.Companion.currentApplication(), string, duration).show()
    }
}