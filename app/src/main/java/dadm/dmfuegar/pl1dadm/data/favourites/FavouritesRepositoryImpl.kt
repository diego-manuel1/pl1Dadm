package dadm.dmfuegar.pl1dadm.data.favourites

import dadm.dmfuegar.pl1dadm.data.favourites.model.QuotationDto
import dadm.dmfuegar.pl1dadm.data.favourites.model.toDomain
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(val favouritesDataSource: FavouritesDataSource): FavouritesRepository {
    override fun addQuotation(quotation: Quotation) {
        favouritesDataSource.addQuotation(quotation)
    }

    override fun obtainConcreteFavourite(id: String): Flow<Quotation> {
        val flowQuotationDto = favouritesDataSource.obtainConcreteFavourite(id)
        return flowQuotationDto.map { quotationDto -> quotationDto.toDomain()}
    }

    override fun obtainFavourites(): Flow<List<Quotation>> {
        return favouritesDataSource.obtainFavourites().map{quotationDtoList->
            quotationDtoList.map{quotationDto ->
                quotationDto.toDomain()
            }
        }
    }

    override fun removeAllFavourites() {
        favouritesDataSource.removeAllFavourites()
    }

    override fun removeQuotation(quotation: Quotation) {
        favouritesDataSource.removeQuotation(quotation)
    }
}