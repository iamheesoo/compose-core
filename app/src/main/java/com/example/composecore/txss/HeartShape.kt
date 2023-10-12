package com.example.composecore.txss

import androidx.compose.foundation.shape.GenericShape

val HeartShape = GenericShape { size, _ ->
    val h = size.height
    val w = size.width
    lineTo(0.5f * w, 0.25f * h)
    cubicTo(
        0.5f * w,
        0.225f * h,
        0.458333333333333f * w,
        0.125f * h,
        0.291666666666667f * w,
        0.125f * h
    )
    cubicTo(
        0.0416666666666667f * w,
        0.125f * h,
        0.0416666666666667f * w,
        0.4f * h,
        0.0416666666666667f * w,
        0.4f * h
    )
    cubicTo(
        0.0416666666666667f * w,
        0.583333333333333f * h,
        0.208333333333333f * w,
        0.766666666666667f * h,
        0.5f * w,
        0.916666666666667f * h
    )
    cubicTo(
        0.791666666666667f * w,
        0.766666666666667f * h,
        0.958333333333333f * w,
        0.583333333333333f * h,
        0.958333333333333f * w,
        0.4f * h
    )
    cubicTo(
        0.958333333333333f * w,
        0.4f * h,
        0.958333333333333f * w,
        0.125f * h,
        0.708333333333333f * w,
        0.125f * h
    )
    cubicTo(0.583333333333333f * w, 0.125f * h, 0.5f * w, 0.225f * h, 0.5f * w, 0.25f * h)
    close()
}