package com.carlospinan.canvasspritesheet

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder
import com.carlospinan.canvasspritesheet.engine.GameView
import com.carlospinan.canvasspritesheet.engine.ThreadEngine

class SpriteSheetGameView(context: Context) : GameView(context = context) {

    private val gameEngine = SpriteSheetEngine(context = context)
    private val threadEngine = ThreadEngine(view = this, surfaceHolder = this.holder)

    init {
        holder.addCallback(this)
    }

    override fun update(delta: Float) {
        gameEngine.update(delta)
    }

    override fun render(canvas: Canvas) {
        gameEngine.draw(canvas)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        gameEngine.create()
        threadEngine.pause = false
        threadEngine.running = true
        threadEngine.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        threadEngine.pause = true
        threadEngine.running = false
        threadEngine.join()
    }
}