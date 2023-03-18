package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.data.newquotation.model.QuotationDto
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import retrofit2.Response

interface NewQuotationDataSource {
    suspend fun getQuotation(language:String): Response<QuotationDto>
}