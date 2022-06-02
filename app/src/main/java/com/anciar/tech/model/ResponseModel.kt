package com.anciar.tech.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseModel {

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

    class Datum {
        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("sectionData")
        @Expose
        var sectionData: List<SectionDatum>? = null
    }

    class SectionDatum {
        @SerializedName("type")
        @Expose
        val type: String? = null

        @SerializedName("typeData")
        @Expose
        val typeData: List<TypeDatum>? = null
    }

    class TypeDatum {
        @SerializedName("id")
        @Expose
        var id: Int? = null

        @SerializedName("image")
        @Expose
        var image: String? = null
    }
}