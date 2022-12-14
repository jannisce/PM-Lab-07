package gt.uvg.pokelist.model

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "url")
    val url: String,
    val urlSplit: List<String> = url.split("/"),
    val id: Int = Integer.valueOf(urlSplit[urlSplit.size-2]),
    @Json(name = "name")
    val name: String
) {
    val imageUrlFront: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    val imageUrlBack: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$id.png"
    val imageUrlShinnyFront: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$id.png"
    val imageUrlShinnyBack: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/$id.png"
}

data class PokemonResponse(@Json(name="results") val result : List<Pokemon>)