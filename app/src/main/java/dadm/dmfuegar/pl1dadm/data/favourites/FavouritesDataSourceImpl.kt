package dadm.dmfuegar.pl1dadm.data.favourites

import dadm.dmfuegar.pl1dadm.data.favourites.model.QuotationDto
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(val favouritesDao: FavouritesDao): FavouritesDataSource {
    override fun addQuotation(quotation: Quotation) {
        favouritesDao.addQuotation(quotation)
    }

    override fun obtainConcreteFavourite(id: String): Flow<QuotationDto> {
        return favouritesDao.obtainConcreteFavourite(id)
    }

    override fun obtainFavourites(): Flow<List<QuotationDto>> {
        return favouritesDao.obtainFavourites()
    }

    override fun removeAllFavourites() {
        favouritesDao.removeAllFavourites()
    }

    override fun removeQuotation(quotation: Quotation) {
        favouritesDao.removeQuotation(quotation)
    }
}