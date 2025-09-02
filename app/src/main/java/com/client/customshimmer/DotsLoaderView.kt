package com.client.customshimmer

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class DotsLoaderView(context: Context) : View(context) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.MAGENTA }
    private var step = 0

    init {
        val animator = ValueAnimator.ofInt(0, 2).apply {
            duration = 600
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                step = it.animatedValue as Int
                invalidate()
            }
        }
        animator.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 200
        val desiredHeight = 80
        val w = resolveSize(desiredWidth, widthMeasureSpec)
        val h = resolveSize(desiredHeight, heightMeasureSpec)
        setMeasuredDimension(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = 15f
        val spacing = 50f
        val cy = height / 2f
        val startX = width / 2f - spacing

        for (i in 0..2) {
            paint.alpha = if (i == step) 255 else 100
            canvas.drawCircle(startX + i * spacing, cy, radius, paint)
        }
    }
}
