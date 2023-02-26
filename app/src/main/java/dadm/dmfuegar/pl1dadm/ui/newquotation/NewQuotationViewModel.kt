package dadm.dmfuegar.pl1dadm.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewQuotationViewModel : ViewModel() {
    private val _userNames = MutableLiveData<String>()
    val userName : LiveData<String>
    get() = _userNames
    fun getUserName(): String{
        return setOf("Alice", "Bob",
            "Charlie", "David").random()
    }

}