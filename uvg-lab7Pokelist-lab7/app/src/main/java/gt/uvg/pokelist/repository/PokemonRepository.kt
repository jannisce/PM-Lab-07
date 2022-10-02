package gt.uvg.pokelist.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object PokemonRepository {

    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    val pokemonService : PokemonService by lazy {
        retrofit.create(PokemonService::class.java)
    }
}

interface PokemonService {
    @GET("pokemon?limit=100")
    fun getFirst100Pokemon(): Call<PokemonResponse>
}

