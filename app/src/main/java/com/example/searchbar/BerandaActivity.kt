package com.example.searchbar

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.searchbar.beranda.ImageSliderAdapter

class BerandaActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var sliderAdapter: ImageSliderAdapter

    private val images =
        listOf(R.drawable.realmepromo2, R.drawable.realmepromo4, R.drawable.realmepromo5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda)

//            BerandaImageSlider
        viewPager2 = findViewById(R.id.viewPager)
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

        val textView = findViewById<TextView>(R.id.textView4)
        textView.gravity = Gravity.CENTER_HORIZONTAL or Gravity.START

        val btnMain = findViewById<Button>(R.id.btnGetS)
        btnMain.setOnClickListener() {
            startActivity(Intent(this@BerandaActivity, MainActivity::class.java))
            Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
            finish()

            fun onButtonClicked(view: View) {
                // Kode untuk menganimasikan tombol
                val button = view as Button

                val rotationAnimator = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f)
                rotationAnimator.duration = 1000
                rotationAnimator.start()
            }


        }

    }
}
