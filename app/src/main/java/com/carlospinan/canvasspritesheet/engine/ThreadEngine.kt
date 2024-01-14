package com.carlospinan.canvasspritesheet.engine

import android.view.SurfaceHolder

class ThreadEngine(
    private val view: GameView,
    private val surfaceHolder: SurfaceHolder
) : Thread() {

    var running: Boolean = false
    var pause: Boolean = false

    override fun run() {
        var lastTimeStamp = System.currentTimeMillis()
        while (running) {
            if (!pause) {
                surfaceHolder.lockCanvas()?.also {
                    synchronized(surfaceHolder) {
                        // Added -1 to prevent ArithmeticException
                        val timeElapsed = System.currentTimeMillis() - (lastTimeStamp - 1)
                        val dt: Float = 1.0f / timeElapsed
                        view.update(dt)
                        view.draw(it)
                        lastTimeStamp = System.currentTimeMillis()
                    }
                    surfaceHolder.unlockCanvasAndPost(it)
                }
            }
            sleep(1000L / FPS)
        }
    }

}