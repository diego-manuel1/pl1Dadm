package dadm.dmfuegar.pl1dadm.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable.TABLE_NAME
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract.FavouritesTable.FAVOURITES_COL_AUTHOR
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract.FavouritesTable.FAVOURITES_COL_ID
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract.FavouritesTable.FAVOURITES_COL_TEXT
import dadm.dmfuegar.pl1dadm.data.favourites.FavouritesContract.FavouritesTable.FAVOURITES_TABLE_NAME

@Entity(tableName = FAVOURITES_TABLE_NAME)
data class QuotationDto(@PrimaryKey @ColumnInfo(name = FAVOURITES_COL_ID) val id:String,
                        @ColumnInfo(name = FAVOURITES_COL_TEXT) val content: String,
                        @ColumnInfo(name = FAVOURITES_COL_AUTHOR)  val author: String)
