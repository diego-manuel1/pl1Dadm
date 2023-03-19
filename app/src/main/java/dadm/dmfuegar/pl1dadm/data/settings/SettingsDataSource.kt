package dadm.dmfuegar.pl1dadm.data.settings

import kotlinx.coroutines.flow.Flow


interface SettingsDataSource {
    fun getUsername(): Flow<String>
}