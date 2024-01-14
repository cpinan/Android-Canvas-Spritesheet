package com.carlospinan.canvasspritesheet.engine

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

abstract class GameView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : SurfaceView(context, attrs), SurfaceHolder.Callback {

    abstract fun update(delta: Float)

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        super.draw(/* canvas = */ canvas)
        with(canvas) {
            save()

            drawColor(/* color = */ BLACK_COLOR)

            val scaleX = width / SCREEN_WIDTH
            val scaleY = height / SCREEN_HEIGHT

            scale(/* sx = */ scaleX, /* sy = */ scaleY)

            render(canvas = canvas)

            restore()
        }
    }

    abstract fun render(canvas: Canvas)

}