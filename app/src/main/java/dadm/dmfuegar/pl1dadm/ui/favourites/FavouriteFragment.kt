package dadm.dmfuegar.pl1dadm.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.dmfuegar.pl1dadm.databinding.FragmentFavouritesBinding

class FavouriteFragment: Fragment(){
    private var _binding: FragmentFavouritesBinding? = null
            private val binding: FragmentFavouritesBinding
            get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFavouritesBinding.bind(view)
        //val adapter =
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}