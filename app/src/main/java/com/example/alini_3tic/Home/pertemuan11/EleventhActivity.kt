package com.example.alini_3tic.Home.pertemuan11

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alini_3tic.R
import com.example.alini_3tic.databinding.ActivityEleventhBinding
import com.google.android.material.tabs.TabLayoutMediator

class EleventhActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEleventhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEleventhBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 11"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        // 1. Inisialisasi adapter
        val tabsAdapter = EleventhTabsAdapter(this)
        // 2. Pasang adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter
        // 3. Hubungkan TabLayout dan ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Atur judul untuk setiap tab
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    // Tambah ikon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    // Badge tanpa angka (hanya titik)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true // ini akan menampilkan badge (titik merah)
                }

                1 -> {
                    tab.text = "Tab B"
                    // Tambah ikon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    // Badge dengan angka
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 5 // ini angka 5 yang bakalan muncul di badge
                }
                2 -> {
                    tab.text = "Tab C"
                    // Tambah ikon
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    // Badge dengan angka
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = false

                }
            }
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}