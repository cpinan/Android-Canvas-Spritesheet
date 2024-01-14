package com.carlospinan.canvasspritesheet.sprites

import android.graphics.Bitmap
import com.carlospinan.canvasspritesheet.engine.objects.Sprite

class MegamanJump(bitmap: Bitmap) : Sprite(
    bitmap = bitmap,
    spriteSheetCols = 7,
    spriteSheetRows = 1,
    fps = 15,
)