package dadm.dmfuegar.pl1dadm.data.favourites

import dadm.dmfuegar.pl1dadm.data.favourites.model.QuotationDto
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun addQuotation(quotation: Quotation)
    suspend fun removeQuotation(quotation: Quotation)
    fun obtainFavourites(): Flow<List<QuotationDto>>
    fun obtainConcreteFavourite(id: String):Flow<QuotationDto>
    fun removeAllFavourites()
}