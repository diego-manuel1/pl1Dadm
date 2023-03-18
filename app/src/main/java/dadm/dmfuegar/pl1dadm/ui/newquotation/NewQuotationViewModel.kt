package dadm.dmfuegar.pl1dadm.ui.newquotation

import androidx.lifecycle.*
import dadm.dmfuegar.pl1dadm.data.newquotation.NewQuotationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dadm.dmfuegar.pl1dadm.domain.model.Quotation
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(val newQuotationRepos: NewQuotationRepository) : ViewModel() {
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

    private val _errorToShow = MutableLiveData<Throwable?>()
    val errorToShow : LiveData<Throwable?>
    get() = _errorToShow

    val isGreetingsVisible = Transformations.map(quotation) { it == null }

    fun getUserName(): String{
        return setOf("Alice", "Bob",
            "Charlie", "David").random()
    }

   /* Versión de getQuotation sin el repositorio
   fun getNewQuotation(){
        _isRefreshing.value = true
        val num = (0..99).random().toString()
        _quotation.value = Quotation(num, "Quotation text #$num", "Author #$num")
        _isRefreshing.value = false
        _showAddFavorite.value = true
    }*/
    //versión de getNewQuotation con el repositorio
    fun getNewQuotation(){
       resetError()
       viewModelScope.launch{
           _isRefreshing.value = true
           newQuotationRepos.getNewQuotation().fold(onSuccess = {q->
               _quotation.value = q
               _showAddFavorite.value = true
           },
               onFailure = {error->
                   _errorToShow.value = error
               })
           _isRefreshing.value = false

       }
    }
    fun addToFavourites(){
        _showAddFavorite.value = false
    }

    fun resetError(){
        _errorToShow.value = null
    }
}