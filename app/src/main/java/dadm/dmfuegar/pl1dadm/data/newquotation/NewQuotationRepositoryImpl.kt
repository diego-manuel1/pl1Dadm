package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.utils.NoInternetException
import domain.model.Quotation
import javax.inject.Inject


class NewQuotationRepositoryImpl @Inject constructor(val newQuotationDataSource: NewQuotationDataSource, val connectivityChecker: ConnectivityChecker): NewQuotationRepository {
    override suspend fun getNewQuotation(): Result<Quotation> {
        if(connectivityChecker.isConnectionAvalilable())
            return newQuotationDataSource.getQuotation()
        else{
            return Result.failure(NoInternetException())
        }
    }
}