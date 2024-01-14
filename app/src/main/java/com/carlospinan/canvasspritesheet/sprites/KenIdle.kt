package com.carlospinan.canvasspritesheet.sprites

import android.graphics.Bitmap
import com.carlospinan.canvasspritesheet.engine.objects.Sprite

class KenIdle(bitmap: Bitmap) : Sprite(
    bitmap = bitmap,
    fps = 10,
    spriteSheetCols = 10,
    spriteSheetRows = 8,
    frameSequence = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
)