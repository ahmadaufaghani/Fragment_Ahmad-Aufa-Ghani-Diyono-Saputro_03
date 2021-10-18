package com.example.fragment_ahmadaufaghanidiyonosaputro_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_ahmadaufaghanidiyonosaputro_03.fragment.HomeFragment
import com.example.fragment_ahmadaufaghanidiyonosaputro_03.fragment.NotificationFragment
import com.example.fragment_ahmadaufaghanidiyonosaputro_03.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.menu_home -> makeCurrentFragment(homeFragment)
                    R.id.menu_notification -> makeCurrentFragment(notificationFragment)
                    R.id.menu_settings -> makeCurrentFragment(settingsFragment)
                }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav, fragment)
            commit()
        }
    }
}