package com.client.customshimmer

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.view.View

class Angle270LoaderView(context: Context) : View(context) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 12f
        strokeCap = Paint.Cap.ROUND
    }
    private var sweep = 0f

    init {
        val animator = ValueAnimator.ofFloat(0f, 360f).apply {
            duration = 1200
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                sweep = it.animatedValue as Float
                invalidate()
            }
        }
        animator.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = 120
        val w = resolveSize(size, widthMeasureSpec)
        val h = resolveSize(size, heightMeasureSpec)
        setMeasuredDimension(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = (width.coerceAtMost(height) / 2f) - paint.strokeWidth
        paint.shader = SweepGradient(width / 2f, height / 2f,
            intArrayOf(Color.GRAY, Color.LTGRAY, Color.GRAY), null)

        val rect = RectF(
            width / 2f - radius,
            height / 2f - radius,
            width / 2f + radius,
            height / 2f + radius
        )

        canvas.save()
        canvas.rotate(270f, width / 2f, height / 2f)
        canvas.drawArc(rect, sweep, 90f, false, paint)
        canvas.restore()
    }
}
