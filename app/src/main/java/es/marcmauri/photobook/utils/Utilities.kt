package es.marcmauri.photobook.utils

import android.content.res.Configuration
import android.content.res.Resources

class Utilities {

    /* SCREEN VARIABLES */
    private val SPAN_COUNT_PORTRAIT = 2
    private val SPAN_COUNT_LANDSCAPE_HiRes = 4
    private val SPAN_COUNT_LANDSCAPE_LowRes = 3

    fun getGridSpanCount(resources: Resources, edgeBtwRes: Int): Int {
        return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            SPAN_COUNT_PORTRAIT
        } else {
            if (resources.configuration.screenWidthDp >= edgeBtwRes)
                SPAN_COUNT_LANDSCAPE_HiRes
            else
                SPAN_COUNT_LANDSCAPE_LowRes
        }
    }

}