package dadm.dmfuegar.pl1dadm.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.model.Quotation

class NewQuotationViewModel : ViewModel() {
    private val _userNames = MutableLiveData<String>()
    val userName : LiveData<String>
    get() = _userNames

    private val _quotation = MutableLiveData<Quotation>()
    val quotation : LiveData<Quotation>
    get() = _quotation

    private val _showIcon = MutableLiveData<Boolean>()
    val showIcon : LiveData<Boolean>
    get() = _showIcon

    private val _showAddFavorite = MutableLiveData<Boolean>()
    val showAddFavorite : LiveData<Boolean>
    get() = _showAddFavorite

    fun getUserName(): String{
        return setOf("Alice", "Bob",
            "Charlie", "David").random()
    }

    fun getNewQuotation(){
        val num = (0..99).random().toString()
        _quotation.value = Quotation(num, "Quotation text #$num", "Author #$num")
        _showIcon.value = true
        _showAddFavorite.value = true
    }

    fun addToFavourites(){
        _showAddFavorite.value = false
    }

}