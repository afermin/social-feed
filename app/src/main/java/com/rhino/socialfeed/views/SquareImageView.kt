package com.rhino.socialfeed.views

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView


/**
 * Created by alexanderjosefermingomez on 11/23/17.
 */
class SquareImageView : ImageView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        var width = MeasureSpec.getSize(widthMeasureSpec)

        super.onMeasure(
                MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY)
        )
    }
}