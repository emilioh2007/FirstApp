package com.emilio.firstapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.emilio.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // criar a toobar
    private lateinit var appBarConfiguration: AppBarConfiguration

    // criar a navegação
    private lateinit var navController: NavController

            // criar  binding
            private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         // configurar o binding
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // configura a navegação e a toobar
        val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

    }
}
