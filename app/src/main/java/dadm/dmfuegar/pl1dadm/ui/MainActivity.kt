package dadm.dmfuegar.pl1dadm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dadm.dmfuegar.pl1dadm.R
import dadm.dmfuegar.pl1dadm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MenuProvider {
    private lateinit var navControllerProp: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navControllerProp = binding.fragmentContainer.getFragment<NavHostFragment>().navController
        (binding.navView as NavigationBarView).setupWithNavController(navControllerProp)

        setupActionBarWithNavController(navControllerProp,
            AppBarConfiguration(navControllerProp.graph)
        )
        addMenuProvider(this)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_about, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if(menuItem.itemId == R.id.aboutDialogFragment) {
            navControllerProp.navigate(R.id.aboutDialogFragment)
            return true
        }
        return false
    }
}