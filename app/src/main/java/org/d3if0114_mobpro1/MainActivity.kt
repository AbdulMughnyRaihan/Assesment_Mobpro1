package org.d3if0114_mobpro1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.d3if0114_mobpro1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitungBmi() }
    }

    private fun hitungBmi() {
        Log.d("MainActivity", "Tombol diklik!")
    }
}