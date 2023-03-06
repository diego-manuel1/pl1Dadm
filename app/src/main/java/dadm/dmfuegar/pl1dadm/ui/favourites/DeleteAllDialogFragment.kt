package dadm.dmfuegar.pl1dadm.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DeleteAllDialogFragment(val buttonManager: ButtonManager): DialogFragment() {
    interface ButtonManager{
        fun buttonPositive(){

        }
        fun buttonNegative(){

        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Delete all favourite quotations")
            .setMessage("Do you really want to delete all quotations?")
            .setPositiveButton("Yes"){_,_->
                buttonManager.buttonPositive()
            }
            .setNegativeButton("No"){_,_->
                buttonManager.buttonNegative()
            }
            .create()
    }
}