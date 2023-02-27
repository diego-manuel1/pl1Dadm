package dadm.dmfuegar.pl1dadm.ui.newquotation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dadm.dmfuegar.pl1dadm.R
import dadm.dmfuegar.pl1dadm.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(), MenuProvider{
    private var _binding: FragmentNewQuotationBinding? = null
            private val binding: FragmentNewQuotationBinding
            get() = _binding!!
    private val viewModel: NewQuotationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
        binding.textView.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
        binding.swipe.isRefreshing = isRefreshing
        binding.swipe.setOnRefreshListener {
            viewModel.getNewQuotation()
        }
        viewModel.userName.observe(viewLifecycleOwner){userName->
            binding.textView.text =
                getString(R.string.welcomeMessage, userName)
        }
        requireActivity().addMenuProvider(this,
            viewLifecycleOwner, Lifecycle.State.RESUMED)
        viewModel.showAddFavorite.observe(viewLifecycleOwner){show->
            binding.addButton.visibility = if (show) View.VISIBLE else View.INVISIBLE
        }
        binding.addButton.setOnClickListener {
            viewModel.addToFavourites()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about,
            menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        TODO("Not yet implemented")
        //getNewQuotation()
    }


}