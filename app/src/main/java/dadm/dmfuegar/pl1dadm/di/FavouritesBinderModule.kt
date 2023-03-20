package dadm.dmfuegar.pl1dadm.di

import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesDataSource
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesDataSourceImpl
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesRepository
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {
    @Binds
    abstract fun bindFavouritesDataSource(favouritesDataSourceImpl: FavouritesDataSourceImpl): FavouritesDataSource
    @Binds
    abstract fun bindFavouritesRepository(favouritesRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository
}