package com.example.assignment_25

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // NavController to manage app navigation
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("nit3213", "onCreate: ")

        // enable edge-to-edge display
        enableEdgeToEdge()

        // set the content view to activity_main layout
        setContentView(R.layout.activity_main)

        // initialise NavController from the NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // set up ActionBar with NavController for navigation support
        setupActionBarWithNavController(navController)

        // Apply window insets to handle system bars (e.g, status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // handle navigation when the up button is pressed
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    // log lifecycle method onStart
    override fun onStart() {
        super.onStart()
        Log.d("nit3213", "onStart: ")
    }

    // Log lifecycle method onResume
    override fun onResume() {
        super.onResume()
        Log.d("nit3213", "onResume: ")
    }

    // Log lifecycle method onPause
    override fun onPause() {
        super.onPause()
        Log.d("nit3213", "onPause: ")
    }

    // Log lifecycle method onStop
    override fun onStop() {
        super.onStop()
        Log.d("nit3213", "onStop: ")
    }

    // Log lifecycle method onDestroy
    override fun onDestroy() {
        super.onDestroy()
        Log.d("nit3213", "onDestroy: ")
    }
}