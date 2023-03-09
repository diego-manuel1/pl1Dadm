package dadm.dmfuegar.pl1dadm.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import domain.model.Quotation

class NewQuotationViewModel : ViewModel() {
    private val _userName = MutableLiveData<String>(getUserName())
    val userName : LiveData<String>
    get() = _userName

    private val _quotation = MutableLiveData<Quotation>()
    val quotation : LiveData<Quotation>
    get() = _quotation

    private val _isRefreshing = MutableLiveData<Boolean>(false)
    val isRefreshing : LiveData<Boolean>
    get() = _isRefreshing

    private val _showAddFavorite = MutableLiveData<Boolean>()
    val showAddFavorite : LiveData<Boolean>
    get() = _showAddFavorite

    val isGreetingsVisible = Transformations.map(quotation) { it == null }

    fun getUserName(): String{
        return setOf("Alice", "Bob",
            "Charlie", "David").random()
    }

    fun getNewQuotation(){
        _isRefreshing.value = true
        val num = (0..99).random().toString()
        _quotation.value = Quotation(num, "Quotation text #$num", "Author #$num")
        _isRefreshing.value = false
        _showAddFavorite.value = true
    }

    fun addToFavourites(){
        _showAddFavorite.value = false
    }

}