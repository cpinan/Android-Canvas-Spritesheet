package com.carlospinan.canvasspritesheet.engine

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException

/**
 * @author Carlos Piñan
 */
fun Context.loadBitmap(resource: String): Bitmap {
    try {
        return BitmapFactory.decodeStream(
            assets.open(resource)
        )
    } catch (e: IOException) {
        throw Exception("There was an error ${e.localizedMessage}")
    }
}