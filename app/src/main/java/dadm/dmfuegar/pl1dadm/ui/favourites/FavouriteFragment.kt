package dadm.dmfuegar.pl1dadm.ui.favourites

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.END
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dadm.dmfuegar.pl1dadm.R
import dadm.dmfuegar.pl1dadm.databinding.FragmentFavouritesBinding

class FavouriteFragment: Fragment(R.layout.fragment_favourites), DeleteAllDialogFragment.ButtonManager, MenuProvider{
    private var _binding: FragmentFavouritesBinding? = null
            private val binding: FragmentFavouritesBinding
            get() = _binding!!
    private val viewModel: FavouritesViewModel by viewModels()
    private val touchHelper = ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0,END){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun isLongPressDragEnabled(): Boolean {
            return false
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            viewModel.deleteQuotationAtPosition(viewHolder.position)
        }

    }
    )

    class Click(val view: View): QuotationListAdapter.ItemClicked{
        override fun onClick(author: String) {
            if(author.equals("Anonymous")){
                val snackbar = Snackbar.make(view, R.string.authorAnonymous, 1000)
                snackbar.show()
            }
            else{

                try{
                    startActivity(
                        view.context, Intent()
                        .setAction(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + author)), null)
                }
                catch (e: ActivityNotFoundException) {
                    val snackbarException = Snackbar.make(view, R.string.errorFindingInformation, 1000)
                    snackbarException.show()
                }
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)
        requireActivity().addMenuProvider(this,
            viewLifecycleOwner, Lifecycle.State.RESUMED)
        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner){
            requireActivity().invalidateMenu()
        }
        val itemClicked = Click(view)
        val adapter = QuotationListAdapter( itemClicked)
        _binding!!.favouriteView.adapter = adapter
        viewModel.favouriteQuotations.observe(viewLifecycleOwner){list->
            adapter.submitList(list)
        }
        touchHelper.attachToRecyclerView(_binding!!.favouriteView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun buttonPositive() {
        super.buttonPositive()
        viewModel.deleteAllQuotations()
    }

    override fun buttonNegative() {
        super.buttonNegative()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(
            R.menu.menu_favourites,
            menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.deleteFavouriteItem) {
            DeleteAllDialogFragment(this).show(childFragmentManager, null)
            return true
        }
        return false
    }

    override fun onPrepareMenu(menu: Menu) {
        super.onPrepareMenu(menu)
        val menuItem = menu.findItem(R.id.deleteFavouriteItem)
        if(viewModel.isDeleteAllVisible.value == true){
            menuItem.setVisible(true)
        }
        else{
            menuItem.setVisible(false)
        }
    }
}