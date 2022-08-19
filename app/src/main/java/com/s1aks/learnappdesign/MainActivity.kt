package com.s1aks.learnappdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.s1aks.learnappdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var navView: ChipNavigationBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView?.setItemSelected(R.id.navigation_home, true)
        navView?.setOnItemSelectedListener { id ->
            when (id) {
                R.id.navigation_home -> {
                    navController.popBackStack()
                    navController.navigate(R.id.nav_home)
                }
                R.id.navigation_classes -> {
                    navController.popBackStack()
                    navController.navigate(R.id.nav_classes)
                }
            }
        }
    }
}