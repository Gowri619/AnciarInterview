package com.anciar.tech.epoxymodel

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.anciar.tech.R
import com.anciar.tech.model.ResponseModel

@EpoxyModelClass(layout = R.layout.epoxy_section_header_item)
abstract class SectionHeaderEpoxyModel(@EpoxyAttribute var model: ResponseModel.Datum?) :
    EpoxyModelWithHolder<SectionHeaderEpoxyModel.HeaderHolder>() {


    override fun bind(@androidx.annotation.NonNull holder: HeaderHolder) {
        holder.tvSectionHeaderTitle.text = model?.name
    }

    class HeaderHolder : EpoxyHolder() {
        lateinit var tvSectionHeaderTitle: TextView

        override fun bindView(itemView: View) {
            tvSectionHeaderTitle = itemView.findViewById(R.id.tvSectionHeaderTitle)
        }
    }
}