package com.rhino.socialfeed.ui.instagram

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.rhino.socialfeed.R
import com.rhino.socialfeed.models.instagram.media.Datum
import com.rhino.socialfeed.ui.instagram.di.InstagramFragmentScope
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropSquareTransformation
import javax.inject.Inject

/**
 * Created by alexanderjosefermingomez on 11/20/17.
 */
@InstagramFragmentScope
class InstagramAdapter @Inject constructor(@InstagramFragmentScope val context: Context,
                                           val picasso: Picasso)
    : RecyclerView.Adapter<InstagramAdapter.ViewHolder>() {

    private val dataSet: MutableList<Datum> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_instagram, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        picasso.load(dataSet[position].images!!.standardResolution!!.url)
                .transform(CropSquareTransformation())
                .into(holder?.imageView)

    }

    override fun getItemCount(): Int = dataSet.count()

    class ViewHolder(val view: View?) : RecyclerView.ViewHolder(view) {
        val root = view
        val imageView = view?.findViewById<ImageView>(R.id.imageView) as ImageView
    }

    fun removeAll() {
        dataSet.clear()
        notifyDataSetChanged()
    }

    fun setData(data: List<Datum>?) {
        dataSet.addAll(data!!)
        notifyDataSetChanged()
    }
}