package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.domain.model.Quotation

interface NewQuotationManager {
    suspend fun getNewQuotation(): Result<Quotation>
}