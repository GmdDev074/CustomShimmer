package com.client.customshimmer

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.FrameLayout

class ShimmerLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var baseColor = Color.LTGRAY
    private var highlightColor = Color.WHITE
    private var duration = 1000
    private var angle = 0
    private var gradientX = 0f
    private var animator: ValueAnimator? = null
    private val paint = Paint()

    init {
        setWillNotDraw(false)
    }

    fun setShimmerColors(base: Int, highlight: Int) {
        baseColor = base
        highlightColor = highlight
    }

    fun setAngle(value: Int) {
        angle = value
    }

    fun startShimmer() {
        animator?.cancel()
        animator = ValueAnimator.ofFloat(0f, width * 2f).apply {
            duration = this@ShimmerLayout.duration.toLong()
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                gradientX = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)

        val shader: Shader = when (angle) {
            -1 -> RadialGradient(
                (width / 2).toFloat(), (height / 2).toFloat(),
                width.coerceAtLeast(height).toFloat(),
                intArrayOf(baseColor, highlightColor, baseColor),
                floatArrayOf(0f, 0.5f, 1f),
                Shader.TileMode.CLAMP
            )
            270 -> LinearGradient(
                0f, gradientX, width.toFloat(), gradientX + height,
                intArrayOf(baseColor, highlightColor, baseColor),
                floatArrayOf(0f, 0.5f, 1f),
                Shader.TileMode.CLAMP
            )
            else -> LinearGradient(
                gradientX, 0f, gradientX + width / 2f, height.toFloat(),
                intArrayOf(baseColor, highlightColor, baseColor),
                floatArrayOf(0f, 0.5f, 1f),
                Shader.TileMode.CLAMP
            )
        }

        paint.shader = shader
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}
