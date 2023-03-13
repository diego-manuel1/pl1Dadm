package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.data.newquotation.model.QuotationDto
import domain.model.Quotation
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(val retrofit: Retrofit): NewQuotationDataSource{
    private val retrofitQuotationService =
        retrofit.create(NewQuotationRetrofit::class.java)
    //Ojo, acuerdate de revisar este método, que parece que no se genera la excepción
    override suspend fun getQuotation(): Response<QuotationDto> {
       /* val success = (0..10).random()
        if(success <= 9){
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            return Result.success(quotation)
        }
        else{
            return Result.failure(Exception())
        }*/

    }

    interface NewQuotationRetrofit{
        @GET("api/1.0/?method=getQuote&format=json&lang=en")
        fun getQuotation(): Response<QuotationDto>
    }
}