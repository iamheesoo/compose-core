package com.example.composecore.core

import android.view.animation.Interpolator
import java.lang.Math.abs
import java.lang.Math.cos

class BetterBounceInterpolator(val bounces: Int, val energy: Double) : Interpolator {
    override fun getInterpolation(x: Float): Float =
        (1.0 + (-abs(cos(x * 10 * bounces / Math.PI)) * getCurveAdjustment(x))).toFloat()

    private fun getCurveAdjustment(x: Float): Double = -(2 * (1 - x) * x * energy + x * x) + 1
}