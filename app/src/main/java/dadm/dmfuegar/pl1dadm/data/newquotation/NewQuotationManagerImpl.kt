package dadm.dmfuegar.pl1dadm.data.newquotation

import androidx.lifecycle.asLiveData
import dadm.dmfuegar.pl1dadm.data.settings.SettingsRepository
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewQuotationManagerImpl @Inject constructor(val settingsRepository: SettingsRepository,val newQuotationRepository: NewQuotationRepository): NewQuotationManager {
    private lateinit var language: String
    init{
        CoroutineScope(SupervisorJob()).launch {
            settingsRepository.getLanguage().collect { languageCode ->
                //System.out.println("Inicializando lenguaje:" + language)
                language = languageCode
            }
        }
    }
    override suspend fun getNewQuotation(): Result<Quotation> {
        //Esto para revisar
        //language = settingsRepository.getLanguage().asLiveData().value.toString()

        System.out.println("Lenguaje elegido: "+language)
        return newQuotationRepository.getNewQuotation(language)
    }
}