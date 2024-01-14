package com.carlospinan.canvasspritesheet

import android.content.Context
import android.graphics.Canvas
import com.carlospinan.canvasspritesheet.engine.GameEngine
import com.carlospinan.canvasspritesheet.engine.SCREEN_HEIGHT
import com.carlospinan.canvasspritesheet.engine.SCREEN_WIDTH
import com.carlospinan.canvasspritesheet.engine.loadBitmap
import com.carlospinan.canvasspritesheet.sprites.KenIdle
import com.carlospinan.canvasspritesheet.sprites.Megaman
import com.carlospinan.canvasspritesheet.sprites.MegamanJump

class SpriteSheetEngine(private val context: Context) : GameEngine() {

    private var megaman: Megaman? = null
    private var kenIdle: KenIdle? = null
    private var megamanJump: MegamanJump? = null

    override fun create() {
        megaman = Megaman(context.loadBitmap(resource = MEGAMAN_ASSET)).apply {
            setPosition(x = width / 2F, y = height / 2F)
        }

        val kenBitmap = context.loadBitmap(resource = KEN_ASSET)
        kenIdle = KenIdle(kenBitmap).apply {
            setPosition(x = SCREEN_WIDTH * 0.5F, y = SCREEN_HEIGHT * 0.5F)
        }

        megamanJump = MegamanJump(bitmap = context.loadBitmap(MEGAMAN_JUMP_ASSET)).apply {
            setPosition(x = SCREEN_WIDTH - width * 0.5F, y = SCREEN_HEIGHT - height * 0.5F)
        }
    }

    override fun draw(canvas: Canvas) {
        megaman?.draw(canvas)
        kenIdle?.draw(canvas)
        megamanJump?.draw(canvas)
    }

    override fun update(delta: Float) {
        megaman?.update(delta)
        kenIdle?.update(delta)
        megamanJump?.update(delta)
    }
}