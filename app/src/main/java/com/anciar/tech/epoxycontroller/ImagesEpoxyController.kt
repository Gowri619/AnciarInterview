package com.anciar.tech.epoxycontroller

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.TypedEpoxyController
import com.anciar.tech.epoxymodel.BigImageEpoxyModel_
import com.anciar.tech.epoxymodel.SectionHeaderEpoxyModel_
import com.anciar.tech.epoxymodel.SmallImageEpoxyModel_
import com.anciar.tech.model.ResponseModel
import java.util.*

class ImagesEpoxyController : TypedEpoxyController<List<ResponseModel.Datum>>() {

    override fun buildModels(data: List<ResponseModel.Datum>) {
        for (i in data) {
            SectionHeaderEpoxyModel_(i)
                .id(UUID.randomUUID().toString())
                .addTo(this)
            for (j in i.sectionData!!) {
                if (j.type.equals("small")) {
                    val smallImageEpoxyModelList: ArrayList<SmallImageEpoxyModel_> = ArrayList()
                    for (k in j.typeData!!) {
                        smallImageEpoxyModelList.add(SmallImageEpoxyModel_(k).id(UUID.randomUUID().toString()))
                    }
                    CarouselModel_().id(UUID.randomUUID().toString())
                        .numViewsToShowOnScreen(2f)
                        .padding(Carousel.Padding.dp(15, 10, 15, 10, 10))
                        .models(smallImageEpoxyModelList).addTo(this)
                } else {
                    for (k in j.typeData!!) {
                        BigImageEpoxyModel_(k).id(UUID.randomUUID().toString()).addTo(this)
                    }
                }
            }
        }
    }

    override fun isStickyHeader(position: Int): Boolean {
        return adapter.getModelAtPosition(position) is SectionHeaderEpoxyModel_
    }
}