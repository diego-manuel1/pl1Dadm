package dadm.dmfuegar.pl1dadm.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.model.Quotation

class FavouritesViewModel : ViewModel() {
    private val _favouriteQuotations : MutableLiveData<List<Quotation>>
    val favouriteQuotations : LiveData<List<Quotation>>
    get() = _favouriteQuotations
    fun getFavouriteQuotations():List<Quotation>{

    }
}