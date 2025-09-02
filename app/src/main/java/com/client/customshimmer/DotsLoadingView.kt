package com.client.customshimmer

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class DotsLoadingView(context: Context) : View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.DKGRAY
        style = Paint.Style.FILL
    }

    private var scale1 = 1f
    private var scale2 = 1f
    private var scale3 = 1f

    init {
        val animator1 = ValueAnimator.ofFloat(1f, 0.3f, 1f).apply {
            duration = 600
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                scale1 = it.animatedValue as Float
                invalidate()
            }
            start()
        }

        val animator2 = ValueAnimator.ofFloat(1f, 0.3f, 1f).apply {
            duration = 600
            repeatCount = ValueAnimator.INFINITE
            startDelay = 200
            addUpdateListener {
                scale2 = it.animatedValue as Float
                invalidate()
            }
            start()
        }

        val animator3 = ValueAnimator.ofFloat(1f, 0.3f, 1f).apply {
            duration = 600
            repeatCount = ValueAnimator.INFINITE
            startDelay = 400
            addUpdateListener {
                scale3 = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = height / 6f
        val centerY = height / 2f
        val spacing = radius * 4

        canvas.drawCircle(width / 2f - spacing, centerY, radius * scale1, paint)
        canvas.drawCircle(width / 2f, centerY, radius * scale2, paint)
        canvas.drawCircle(width / 2f + spacing, centerY, radius * scale3, paint)
    }
}
