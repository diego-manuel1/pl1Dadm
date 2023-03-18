package dadm.dmfuegar.pl1dadm.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor() : ViewModel() {
    private val _favouriteQuotations = MutableLiveData<List<Quotation>>(getFavouriteQuotations())
    val favouriteQuotations : LiveData<List<Quotation>>
    get() = _favouriteQuotations
    val isDeleteAllVisible =
        Transformations.map(favouriteQuotations) { it.isNotEmpty() }
    private fun getFavouriteQuotations():List<Quotation>{
        var list = mutableListOf<Quotation>()
        list.add(Quotation("1", "Hola", "Albert Einstein"))
        list.add(Quotation("2", "Adiós", "Anonymous"))
        for(i in 3 .. 20){
            val num = (0..99).random().toString()
            val q = Quotation(num, "Quotation text #$num", "Author #$num")
            list.add(q)
        }
        return list
    }
    fun deleteQuotationAtPosition(position: Int){
        val list = _favouriteQuotations.value?.toMutableList()
        list?.removeAt(position)
        _favouriteQuotations.value = list!!
    }

    fun deleteAllQuotations(){
        _favouriteQuotations.value = listOf()
    }
}