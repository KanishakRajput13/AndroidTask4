package com.example.sitask4

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var drawerNavigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setRestoreState(true)
            .setPopUpTo(R.id.nav_graph, true)
            .build()
        //setting the logic of bottom navigation

        val userName = bottomNavigationView.menu.findItem(R.id.username)
        userName.setOnMenuItemClickListener {
            navController.navigate(R.id.userFragment2,null,navOptions)
            bottomNavigationView.menu.findItem(R.id.username).isChecked = true
            true
        }

        val home = bottomNavigationView.menu.findItem(R.id.home)
        home.setOnMenuItemClickListener {
            navController.navigate(R.id.homeFragment2,null,navOptions)
            bottomNavigationView.menu.findItem(R.id.home).isChecked = true
            true
        }

        val badges = bottomNavigationView.menu.findItem(R.id.badges)
        badges.setOnMenuItemClickListener {
            navController.navigate(R.id.badgeFragment2,null,navOptions)
            bottomNavigationView.menu.findItem(R.id.badges).isChecked = true
            true
        }

        val solved = bottomNavigationView.menu.findItem(R.id.solved)
        solved.setOnMenuItemClickListener {
            navController.navigate(R.id.solvedFragment2,null,navOptions)
            bottomNavigationView.menu.findItem(R.id.solved).isChecked = true
            true
        }

        val submissions = bottomNavigationView.menu.findItem(R.id.submission)
        submissions.setOnMenuItemClickListener {
            navController.navigate(R.id.submissionFragment2,null,navOptions)
            bottomNavigationView.menu.findItem(R.id.submission).isChecked = true
            true
        }


        // setting the logic for drawer navigation

        val drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerNavigationView = findViewById(R.id.nav_view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerNavigationView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.home -> {
                    navController.navigate(R.id.homeFragment2,null,navOptions)
                    bottomNavigationView.menu.findItem(R.id.home).isChecked = true
                }
                R.id.badges ->{
                    navController.navigate(R.id.badgeFragment2,null,navOptions)
                    bottomNavigationView.menu.findItem(R.id.badges).isChecked = true
                }
                R.id.solved ->{
                    navController.navigate(R.id.solvedFragment2,null,navOptions)
                    bottomNavigationView.menu.findItem(R.id.solved).isChecked = true
                }
                R.id.submission ->{
                    navController.navigate(R.id.submissionFragment2,null,navOptions)
                    bottomNavigationView.menu.findItem(R.id.submission).isChecked = true
                }
                R.id.username ->{
                    navController.navigate(R.id.userFragment2,null,navOptions)
                    bottomNavigationView.menu.findItem(R.id.username).isChecked = true
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setRestoreState(true)
            .setPopUpTo(R.id.nav_graph, true)
            .build()
        if (navController.currentDestination?.id != R.id.homeFragment2) {
            navController.navigate(R.id.homeFragment2,null,navOptions)
            bottomNavigationView.menu.findItem(R.id.home).isChecked = true
        } else {
            super.onBackPressed()
        }
    }
}