package dadm.dmfuegar.pl1dadm.data.favourites

import dadm.dmfuegar.pl1dadm.data.favourites.model.QuotationDto
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun addQuotation(quotationDto: QuotationDto)
    suspend fun removeQuotation(quotationDto: QuotationDto)
    fun obtainFavourites(): Flow<List<QuotationDto>>
    fun obtainConcreteFavourite(id: String):Flow<QuotationDto?>
    fun removeAllFavourites()
}