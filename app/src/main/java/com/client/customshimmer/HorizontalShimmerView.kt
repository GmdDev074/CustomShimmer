package com.client.customshimmer

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.view.View

class HorizontalShimmerView(context: Context) : View(context) {
    private val paint = Paint()
    private var gradientX = 0f

    init {
        val animator = ValueAnimator.ofFloat(-500f, 500f).apply {
            duration = 1500
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                gradientX = it.animatedValue as Float
                invalidate()
            }
        }
        animator.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val shader = LinearGradient(
            gradientX, 0f, gradientX + width, 0f,
            intArrayOf(Color.LTGRAY, Color.DKGRAY, Color.LTGRAY),
            null,
            Shader.TileMode.CLAMP
        )
        paint.shader = shader
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}
