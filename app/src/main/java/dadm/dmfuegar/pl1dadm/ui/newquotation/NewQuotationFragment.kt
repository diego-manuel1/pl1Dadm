package dadm.dmfuegar.pl1dadm.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.dmfuegar.pl1dadm.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(){
    private var _binding: FragmentNewQuotationBinding? = null
            private val binding: FragmentNewQuotationBinding
            get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}