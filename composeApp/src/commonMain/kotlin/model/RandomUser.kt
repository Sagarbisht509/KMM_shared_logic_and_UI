package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUser(
    @SerialName("name")
    val name: Name = Name(),
    @SerialName("picture")
    val picture: Picture = Picture()
)
