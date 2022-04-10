package com.khai.mycv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.khai.mycv.databinding.ActivityMainBinding

interface IBackPressedHandler {
    enum class Action {
        DO_BACKPRESS, SKIP_BACKPRESS
    }

    fun onBackPressed(): Action
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        setSupportActionBar(binding.materialToolbar)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_education,
                R.id.navigation_experience,
                R.id.navigation_fun,
                R.id.navigation_sandbox
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.navigateUp()
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    //    https://stackoverflow.com/questions/5448653/how-to-implement-onbackpressed-in-fragments
    override fun onBackPressed() {
        val fragment =
            this.supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val backPressAction = (fragment as? IBackPressedHandler)?.onBackPressed()

        if (backPressAction == null || backPressAction == IBackPressedHandler.Action.DO_BACKPRESS) {
            super.onBackPressed()
        }
    }
}

