package dadm.dmfuegar.pl1dadm.data.newquotation

import domain.model.Quotation

interface NewQuotationDataSource {
    suspend fun getQuotation(): Result<Quotation>
}