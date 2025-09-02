package com.client.customshimmer

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.view.View

class CircularLoaderView(context: Context) : View(context) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 12f
        color = Color.BLUE
    }
    private var sweepAngle = 0f

    init {
        val animator = ValueAnimator.ofFloat(0f, 360f).apply {
            duration = 1000
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                sweepAngle = it.animatedValue as Float
                invalidate()
            }
        }
        animator.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = (width.coerceAtMost(height) / 2f) - 20
        val rect = RectF(
            width / 2f - radius,
            height / 2f - radius,
            width / 2f + radius,
            height / 2f + radius
        )
        canvas.drawArc(rect, sweepAngle, 120f, false, paint)
    }
}
