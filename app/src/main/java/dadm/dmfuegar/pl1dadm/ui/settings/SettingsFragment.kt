package dadm.dmfuegar.pl1dadm.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.dmfuegar.pl1dadm.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment(){
    private var _binding: FragmentSettingsBinding? = null
            private val binding: FragmentSettingsBinding
            get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}