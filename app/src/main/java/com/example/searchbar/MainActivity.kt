package com.example.searchbar

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.searchbar.beranda.ImageSliderAdapter
import com.example.searchbar.cart.CartFragment
import com.example.searchbar.home.HomeFragment
import com.example.searchbar.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var sliderAdapter: ImageSliderAdapter

    private val images =
        listOf(R.drawable.realmepromo2, R.drawable.realmepromo4, R.drawable.realmepromo5)

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_shop -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.rvDailyActivity, HomeFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.rvDailyActivity, CartFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.rvDailyActivity, ProfileFragment()).commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(R.id.rvDailyActivity, HomeFragment())
            .commit()


        //            BerandaImageSlider
        viewPager2 = findViewById(R.id.viewpager)
        sliderAdapter = ImageSliderAdapter(this, images)
        viewPager2.adapter = sliderAdapter

        // Set looping behavior
        viewPager2.offscreenPageLimit = images.indexOf(0)
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Start auto-scrolling
        val handler = Handler()
        val runnable = Runnable {
            val currentItem = viewPager2.currentItem
            viewPager2.setCurrentItem(
                if (currentItem == images.size - 1) 0
                else currentItem + 1, true
            )
        }
        val delay = 3000L // Delay between slides (in milliseconds)
        handler.postDelayed(runnable, delay)

    }

}