package com.base.app_hackathon

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import org.osmdroid.config.Configuration

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    // Lista de imágenes (deben existir en res/drawable/)
    private val images = listOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ImageAdapter(images)
        val btn = findViewById<Button>(R.id.btnComenzar)

        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        (viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Margen entre imágenes (ajusta el valor a tu gusto, ej. 40 = 40px)
        val marginTransformer = MarginPageTransformer(40)
        viewPager.setPageTransformer(marginTransformer)

        autoScrollImages()

        btn.setOnClickListener {
            val inten = Intent(this, Login_1::class.java)
            startActivity(inten)
        }
    }

    private fun autoScrollImages() {
        val runnable = object : Runnable {
            override fun run() {
                if (currentPage == images.size) currentPage = 0
                viewPager.setCurrentItem(currentPage++, true)
                handler.postDelayed(this, 3000) // cada 3 segundos
            }
        }
        handler.post(runnable)
    }
}

