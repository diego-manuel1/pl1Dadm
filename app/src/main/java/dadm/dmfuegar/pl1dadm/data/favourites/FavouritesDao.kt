package dadm.dmfuegar.pl1dadm.data.favourites

import androidx.room.*
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract.FavouritesTable.FAVOURITES_COL_ID
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract.FavouritesTable.FAVOURITES_TABLE_NAME
import dadm.dmfuegar.pl1dadm.data.newquotation.model.QuotationDto
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotation(quotation: Quotation)
    @Delete
    suspend fun removeQuotation(quotation: Quotation)
    @Query("SELECT * FROM ${FAVOURITES_TABLE_NAME}")
    fun obtainFavourites(): Flow<List<QuotationDto>>
    @Query("SELECT * FROM $FAVOURITES_TABLE_NAME WHERE $FAVOURITES_COL_ID = :id")
    fun obtainConcreteFavourite(id: String):Flow<QuotationDto>
    @Query("DELETE FROM $FAVOURITES_TABLE_NAME")
    fun removeAllFavourites()
}