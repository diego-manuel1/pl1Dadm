package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.data.newquotation.model.QuotationDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewQuotationRetrofit {
    @GET("api/1.0/?method=getQuote&format=json")
    fun getQuotation(@Query("lang") language: String): Response<QuotationDto>
}