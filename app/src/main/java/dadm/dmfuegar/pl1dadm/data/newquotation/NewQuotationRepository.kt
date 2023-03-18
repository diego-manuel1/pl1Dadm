package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.domain.model.Quotation

interface NewQuotationRepository {
    suspend fun getNewQuotation():Result<Quotation>
}