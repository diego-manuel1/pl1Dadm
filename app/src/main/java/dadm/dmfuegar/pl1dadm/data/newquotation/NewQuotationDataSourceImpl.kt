package dadm.dmfuegar.pl1dadm.data.newquotation

import dadm.dmfuegar.pl1dadm.data.newquotation.model.QuotationDto
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.intellij.lang.annotations.Language
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject constructor(val retrofit: Retrofit): NewQuotationDataSource{
    private val retrofitQuotationService =
        retrofit.create(NewQuotationRetrofit::class.java)
    override suspend fun getQuotation(language: String): Response<QuotationDto> {
        try{
            return retrofitQuotationService.getQuotation(language)
        }
        catch(e:Exception){
            return Response.error(405, // Could be any other code and text, because we are not using it
                ResponseBody.create(MediaType.parse("text/plain"), e.toString()))
        }
    }
}