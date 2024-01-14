package com.carlospinan.canvasspritesheet.engine

import android.graphics.Canvas

abstract class GameEngine {

    abstract fun create()

    abstract fun draw(canvas: Canvas)

    abstract fun update(delta: Float)

}