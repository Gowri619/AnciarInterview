package com.anciar.tech.epoxymodel

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.anciar.tech.R
import com.anciar.tech.model.ResponseModel
import com.bumptech.glide.Glide

@EpoxyModelClass(layout = R.layout.epoxy_big_image_item)
abstract class BigImageEpoxyModel(@EpoxyAttribute var model: ResponseModel.TypeDatum?) :
    EpoxyModelWithHolder<BigImageEpoxyModel.HeaderHolder>() {


    override fun bind(@androidx.annotation.NonNull holder: HeaderHolder) {
        Glide.with(holder.bigImageView.context).load(model?.image).into(holder.bigImageView)
    }

    class HeaderHolder : EpoxyHolder() {
        lateinit var bigImageView: ImageView

        override fun bindView(itemView: View) {
            bigImageView = itemView.findViewById(R.id.bigImageView)
        }
    }
}