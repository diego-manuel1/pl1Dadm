package dadm.dmfuegar.pl1dadm.data.newquotation

import domain.model.Quotation

interface NewQuotationRepository {
    suspend fun getNewQuotation():Result<Quotation>
}