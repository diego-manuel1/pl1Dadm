package dadm.dmfuegar.pl1dadm.data.newquotation.model

import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import retrofit2.Response
import java.io.IOException

fun QuotationDto.toDomain() = Quotation(quoteLink, quoteText, quoteAuthor)

fun Response<QuotationDto>.toDomain() =
    if(isSuccessful) Result.success((body() as QuotationDto).toDomain())
    else Result.failure(IOException())