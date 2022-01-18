package uas.seftian.pokedexbeneran.repository

import dagger.hilt.android.scopes.ActivityScoped
import uas.seftian.pokedexbeneran.data.remote.PokeApi
import uas.seftian.pokedexbeneran.data.remote.responses.Pokemon
import uas.seftian.pokedexbeneran.data.remote.responses.PokemonList
import uas.seftian.pokedexbeneran.util.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api : PokeApi
){
    suspend fun getPokemonList(limit:Int, offset:Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e:Exception){
            return Resource.Error("An Unknown error ocured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName : String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e:Exception){
            return Resource.Error("An Unknown error ocured")
        }
        return Resource.Success(response)
    }
}