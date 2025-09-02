package com.client.customshimmer

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

object CustomShimmer {

    fun clearAll(textView: TextView, imageView: ImageView, docContainer: LinearLayout) {
        removeOverlay(textView)
        removeOverlay(imageView)
        removeOverlay(docContainer)

        // restore visibility
        textView.visibility = View.VISIBLE
        imageView.visibility = View.VISIBLE
        docContainer.visibility = View.VISIBLE
    }

    fun showHorizontal(textView: TextView, imageView: ImageView, docContainer: LinearLayout) {
        hideOthers(textView, imageView, docContainer, textView)
        overlayView(textView, HorizontalShimmerView(textView.context))
    }

    fun showCircular(textView: TextView, imageView: ImageView, docContainer: LinearLayout) {
        hideOthers(textView, imageView, docContainer, imageView)
        overlayView(imageView, CircularLoaderView(imageView.context))
    }

    fun showAngle270(textView: TextView, imageView: ImageView, docContainer: LinearLayout) {
        hideOthers(textView, imageView, docContainer, docContainer)
        attachOverlay(docContainer, Angle270LoaderView(docContainer.context))
    }

    fun showDots(textView: TextView, imageView: ImageView, docContainer: LinearLayout) {
        hideOthers(textView, imageView, docContainer, docContainer)
        attachOverlay(docContainer, DotsLoaderView(docContainer.context))
    }

    // ---------------- helper functions ----------------
    private fun hideOthers(tv: TextView, iv: ImageView, doc: LinearLayout, show: View) {
        tv.visibility = if (show == tv) View.VISIBLE else View.GONE
        iv.visibility = if (show == iv) View.VISIBLE else View.GONE
        doc.visibility = if (show == doc) View.VISIBLE else View.GONE
    }

    private fun overlayView(target: View, loader: View) {
        val parent = target.parent as? ViewGroup ?: return

        // Wrap in FrameLayout if not wrapped already
        if (parent !is FrameLayout) {
            val index = parent.indexOfChild(target)
            parent.removeView(target)

            val frame = FrameLayout(target.context).apply {
                layoutParams = target.layoutParams
            }
            parent.addView(frame, index)
            frame.addView(target)
        }

        val frameParent = target.parent as FrameLayout

        // remove any previous overlay
        (frameParent.getTag() as? View)?.let {
            frameParent.removeView(it)
        }

        // add new overlay
        frameParent.addView(loader, FrameLayout.LayoutParams(
            target.width.takeIf { it > 0 } ?: ViewGroup.LayoutParams.MATCH_PARENT,
            target.height.takeIf { it > 0 } ?: ViewGroup.LayoutParams.MATCH_PARENT
        ))
        frameParent.setTag(loader)
    }

    private fun attachOverlay(target: View, overlay: View) {
        val parent = target.parent
        if (parent !is ViewGroup) {
            // If no parent, just overlay directly inside a FrameLayout wrapper
            val frame = FrameLayout(target.context).apply {
                layoutParams = target.layoutParams
                addView(target)
                addView(overlay, FrameLayout.LayoutParams(
                    target.layoutParams.width,
                    target.layoutParams.height
                ))
            }
            return
        }

        val index = parent.indexOfChild(target)

        // Replace with FrameLayout
        parent.removeView(target)
        val frame = FrameLayout(target.context).apply {
            layoutParams = target.layoutParams
            addView(target) // keep original target inside
            addView(overlay, FrameLayout.LayoutParams(
                target.layoutParams.width,
                target.layoutParams.height
            ))
        }
        parent.addView(frame, index)
    }



    private fun removeOverlay(target: View) {
        val frameParent = target.parent as? FrameLayout ?: return
        (frameParent.getTag() as? View)?.let {
            frameParent.removeView(it)
            frameParent.setTag(null)
        }
    }
}
