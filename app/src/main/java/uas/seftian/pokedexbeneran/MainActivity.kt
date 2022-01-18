package uas.seftian.pokedexbeneran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import uas.seftian.pokedexbeneran.pokemondetail.PokemonDetailScreen
import uas.seftian.pokedexbeneran.pokemonlist.PokemonListScreen
import uas.seftian.pokedexbeneran.ui.theme.PokedexBeneranTheme
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexBeneranTheme {
                //set up navigation
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination="pokemon_list_screen"
                ){
                    composable("pokemon_list_screen"){
                        PokemonListScreen(navController = navController)
                    }
                    composable(
                        "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor"){
                                type = NavType.IntType
                            },
                            navArgument("pokemonName"){
                                type= NavType.StringType
                            }
                        )
                    ){
                        var dominantColor = remember{
                            var color = it.arguments?.getInt("dominantColor")
                            color?.let{ Color(it) } ?: Color.White
                        }
                        val pokemonName = remember{
                            it.arguments?.getString("pokemonName")
                        }
                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName?.toLowerCase(Locale.ROOT) ?: "" ,
                            navController = navController)

                    }
                }

            }
        }
    }
}


