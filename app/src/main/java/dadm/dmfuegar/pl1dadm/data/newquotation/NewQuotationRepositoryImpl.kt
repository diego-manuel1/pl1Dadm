package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.data.newquotation.model.toDomain
import dadm.dmfuegar.pl1dadm.utils.NoInternetException
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import javax.inject.Inject


class NewQuotationRepositoryImpl @Inject constructor(val newQuotationDataSource: NewQuotationDataSource, val connectivityChecker: ConnectivityChecker): NewQuotationRepository {
    override suspend fun getNewQuotation(language: String): Result<Quotation> {
        if(connectivityChecker.isConnectionAvalilable())
            //return newQuotationDataSource.getQuotation(arrayOf("en","ru", "xx").random()).toDomain()
            return newQuotationDataSource.getQuotation(language).toDomain()
        else{
            return Result.failure(NoInternetException())
        }
    }
}