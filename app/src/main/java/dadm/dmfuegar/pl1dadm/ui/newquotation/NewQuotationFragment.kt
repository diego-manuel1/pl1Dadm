package dadm.dmfuegar.pl1dadm.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dadm.dmfuegar.pl1dadm.R
import dadm.dmfuegar.pl1dadm.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(){
    private var _binding: FragmentNewQuotationBinding? = null
            private val binding: FragmentNewQuotationBinding
            get() = _binding!!
    private val viewModel: NewQuotationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
        viewModel.userName.observe(viewLifecycleOwner){userName->
            binding.textView.text =
                getString(R.string.welcomeMessage, userName)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}