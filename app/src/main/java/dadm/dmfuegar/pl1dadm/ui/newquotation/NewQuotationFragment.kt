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
import com.google.android.material.snackbar.Snackbar
import dadm.dmfuegar.pl1dadm.R
import dadm.dmfuegar.pl1dadm.databinding.FragmentNewQuotationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation), MenuProvider{
    private var _binding: FragmentNewQuotationBinding? = null
            private val binding: FragmentNewQuotationBinding
            get() = _binding!!
    private val viewModel: NewQuotationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewQuotationBinding.bind(view)
        binding.swipe.setOnRefreshListener {
            viewModel.getNewQuotation()
        }
        viewModel.isGreetingsVisible.observe(viewLifecycleOwner){visible->
            binding.welcomeMessage.visibility = if (visible) View.VISIBLE else View.INVISIBLE
        }
        viewModel.userName.observe(viewLifecycleOwner){userName->
            binding.welcomeMessage.text =
                getString(R.string.welcomeMessage, userName)
        }
        viewModel.isRefreshing.observe(viewLifecycleOwner){isRefreshing->
            binding.swipe.isRefreshing = isRefreshing
        }
        viewModel.quotation.observe(viewLifecycleOwner){q->
            binding.textCita.text = q.content
            val author = q.author
            if(author.equals("")) {
                binding.textAuthor.text = "Anonymous"
            }
            else{
                binding.textAuthor.text = author
            }
        }
        requireActivity().addMenuProvider(this,
            viewLifecycleOwner, Lifecycle.State.RESUMED)
        viewModel.showAddFavorite.observe(viewLifecycleOwner){show->
            binding.addButton.visibility = if (show) View.VISIBLE else View.INVISIBLE
        }
        viewModel.errorToShow.observe(viewLifecycleOwner){error->
            if(error!=null){
                val snackbar = Snackbar.make(view, R.string.newQuotationException, 1000)
                snackbar.show()
            }
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
        menuInflater.inflate(R.menu.menu_new_quotation,
            menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.refreshItem) {
            viewModel.getNewQuotation()
            return true
        }
        return false
    }


}