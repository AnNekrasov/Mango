package android.example.tng.common

import android.example.tng.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // super.onViewCreated(view, savedInstanceState)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHost
        navController  = navHost.navController



    }
    fun initBottomNav(){
        bottomNavigation = findViewById(R.id.nav_view)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHost
        navController  = navHost.navController
        bottomNavigation.setOnItemReselectedListener {
            when(it.itemId){
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                }
                R.id.editProfileFragment ->{
                    navController.navigate(R.id.editProfileFragment)
                }

            }

        }

    }


}