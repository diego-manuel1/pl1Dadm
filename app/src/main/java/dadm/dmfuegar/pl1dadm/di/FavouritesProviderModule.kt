package dadm.dmfuegar.pl1dadm.di

import android.content.Context
import androidx.room.Room
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract.FAVOURITES_DATABASE
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesDao
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavouritesProviderModule {
    @Provides
    @Singleton
    fun provideFavouritesDatabase(@ApplicationContext context: Context): FavouritesDatabase{
        return Room.databaseBuilder(context, (FavouritesDatabase::class.java), FAVOURITES_DATABASE).build()
    }
    @Provides
    fun provideFavouritesDao(favouritesDatabase: FavouritesDatabase): FavouritesDao{
        return favouritesDatabase.favouritesDao()
    }
}