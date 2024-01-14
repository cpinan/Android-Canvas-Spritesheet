package com.carlospinan.canvasspritesheet.engine.objects

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.RectF
import android.util.Log
import com.carlospinan.canvasspritesheet.engine.FPS
import com.carlospinan.canvasspritesheet.engine.GAME_TAG

open class Sprite(
    private val bitmap: Bitmap,
    val fps: Int = FPS,
    val spriteSheetCols: Int = 1,
    val spriteSheetRows: Int = 1,
    val frameSequence: Array<Int>? = null,
    anchorPointX: Float = 0.5F,
    anchorPointY: Float = 0.5F,
) {

    private var x: Float = 0f
    private var y: Float = 0f
    private var frameCount: Float = 0F
    private var visible: Boolean = true
    private var isAnimated: Boolean = true
    val width: Int = bitmap.width / spriteSheetCols
    val height: Int = bitmap.height / spriteSheetRows

    private var currentFrame: Int = 0
    private var currentFrameFromSequence = 0
    private val anchorX: Float = width * anchorPointX
    private val anchorY: Float = height * anchorPointY

    fun update(delta: Float) {
        if (!visible) {
            return
        }
        if (frameCount >= (1F / fps)) {
            nextFrame()
            frameCount = 0F
        } else {
            frameCount += delta
        }
    }

    fun draw(canvas: Canvas) {
        if (!visible) {
            return
        }
        val row = currentFrame / spriteSheetCols
        val column = currentFrame % spriteSheetCols
        Log.d(GAME_TAG, "row = $row ; column = $column")
        val sourceRect = Rect(
            column * width,
            row * height,
            column * width + width,
            row * height + height
        )
        val destinationRect = RectF(
            x - anchorX, y - anchorY, x + width - anchorX, y + height - anchorY
        )
        canvas.drawBitmap(
            bitmap,
            sourceRect,
            destinationRect,
            null
        )
    }

    fun setPosition(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    private fun nextFrame() {
        if (!isAnimated) {
            return
        }
        if (frameSequence != null) {
            currentFrame = frameSequence[currentFrameFromSequence++]
            currentFrameFromSequence %= frameSequence.size
        } else {
            currentFrame++
            currentFrame %= (spriteSheetCols * spriteSheetRows)
        }
    }
}