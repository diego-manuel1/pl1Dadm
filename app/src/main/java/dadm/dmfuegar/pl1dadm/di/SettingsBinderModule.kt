package dadm.dmfuegar.pl1dadm.di

import dadm.dmfuegar.pl1dadm.data.settings.SettingsDataSource
import dadm.dmfuegar.pl1dadm.data.settings.SettingsDataSourceImpl
import dadm.dmfuegar.pl1dadm.data.settings.SettingsRepository
import dadm.dmfuegar.pl1dadm.data.settings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {
    @Binds
    abstract fun bindSettingsDataSource(settingsDataSourceImp: SettingsDataSourceImpl):SettingsDataSource
    @Binds
    abstract fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl):SettingsRepository
}