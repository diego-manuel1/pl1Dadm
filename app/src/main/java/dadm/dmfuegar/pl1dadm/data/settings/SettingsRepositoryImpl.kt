package dadm.dmfuegar.pl1dadm.data.settings

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(val settingsDataSource: SettingsDataSource): SettingsRepository {
    override fun getUsername(): Flow<String> {
        return settingsDataSource.getUsername()
    }
}