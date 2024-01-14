package com.carlospinan.canvasspritesheet.sprites

import android.graphics.Bitmap
import com.carlospinan.canvasspritesheet.engine.objects.Sprite

class Megaman(bitmap: Bitmap) : Sprite(
    bitmap = bitmap,
    spriteSheetCols = 5,
    spriteSheetRows = 2,
    fps = 10,
)