package dadm.dmfuegar.pl1dadm.data.newquotation

import domain.model.Quotation
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(): NewQuotationDataSource{
    //Ojo, acuerdate de revisar este método, que parece que no se genera la excepción
    override suspend fun getQuotation(): Result<Quotation> {
        val success = (0..10).random()
        if(success <= 9){
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            return Result.success(quotation)
        }
        else{
            return Result.failure(Exception())
        }
    }
}