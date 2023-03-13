package dadm.dmfuegar.pl1dadm.data.newquotation

import domain.model.Quotation
import javax.inject.Inject


class NewQuotationRepositoryImpl @Inject constructor(): NewQuotationRepository {
    override suspend fun getNewQuotation(): Result<Quotation> {
        val success = (0..100).random()
        if(success <= 90){
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            return Result.success(quotation)
        }
        else{
            return Result.failure(Exception())
        }
    }
}