package uas.seftian.pokedexbeneran.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")
    val redblue: RedBlue,
    val yellow: Yellow
)