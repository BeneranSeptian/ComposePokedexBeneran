package uas.seftian.pokedexbeneran.data.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyalphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    val xy: XY
)