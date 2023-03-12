package dadm.dmfuegar.pl1dadm.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dadm.dmfuegar.pl1dadm.R

class DeleteAllDialogFragment(): DialogFragment() {
    /*interface ButtonManager{
        fun buttonPositive(){

        }
        fun buttonNegative(){

        }
    }
*/
    private val viewModel: FavouritesViewModel by activityViewModels()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle(R.string.DeleteAllTitle)
            .setMessage(R.string.DeletaAllMessage)
            .setPositiveButton(R.string.YesButton){_,_->
                //buttonManager.buttonPositive()
                viewModel.deleteAllQuotations()
                dismiss()
            }
            .setNegativeButton(R.string.NoButton){_,_->
            }
            .create()
    }
}