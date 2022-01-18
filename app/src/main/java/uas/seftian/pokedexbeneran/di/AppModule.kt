package uas.seftian.pokedexbeneran.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uas.seftian.pokedexbeneran.data.remote.PokeApi
import uas.seftian.pokedexbeneran.repository.PokemonRepository
import uas.seftian.pokedexbeneran.util.Constant.BASE_URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokemonRepository(
        api : PokeApi
    )= PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}