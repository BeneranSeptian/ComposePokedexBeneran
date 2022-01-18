package uas.seftian.pokedexbeneran.pokemondetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uas.seftian.pokedexbeneran.data.remote.responses.Pokemon
import uas.seftian.pokedexbeneran.repository.PokemonRepository
import uas.seftian.pokedexbeneran.util.Resource
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {
    suspend fun getPokemonInfo(pokemonName : String):Resource<Pokemon>{

        return repository.getPokemonInfo(pokemonName)
    }
}