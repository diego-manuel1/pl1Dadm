package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.data.newquotation.model.QuotationDto
import domain.model.Quotation
import retrofit2.Response

interface NewQuotationDataSource {
    suspend fun getQuotation(): Response<QuotationDto>
}