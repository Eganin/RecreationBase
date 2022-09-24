package com.example.recreationbase.data.remote.dto.tours

import com.example.recreationbase.data.remote.dto.Image
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TourHomeDto(
    @SerialName("id") var id: Int? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("type") var type: String? = null,
    //@SerialName("night") var night: String? = null,
    @SerialName("url") var url: String? = null,
    @SerialName("image") var image: Image? = Image(),
    @SerialName("base") var base: TourBaseDto? = TourBaseDto()
)
