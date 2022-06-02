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

@EpoxyModelClass(layout = R.layout.epoxy_small_image_item)
abstract class SmallImageEpoxyModel(@EpoxyAttribute var model: ResponseModel.TypeDatum?) :
    EpoxyModelWithHolder<SmallImageEpoxyModel.HeaderHolder>() {


    override fun bind(@androidx.annotation.NonNull holder: HeaderHolder) {
        Glide.with(holder.smallImageView.context).load(model?.image).into(holder.smallImageView)
    }

    class HeaderHolder : EpoxyHolder() {
        lateinit var smallImageView: ImageView

        override fun bindView(itemView: View) {
            smallImageView = itemView.findViewById(R.id.smallImageView)
        }
    }
}