package dadm.dmfuegar.pl1dadm.data.favourites.model

import dadm.dmfuegar.pl1dadm.data.favourites.model.QuotationDto
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import retrofit2.Response
import java.io.IOException

fun QuotationDto.toDomain() = Quotation(id, content, author)

fun Quotation.toDto() =
    QuotationDto(id, content, author)