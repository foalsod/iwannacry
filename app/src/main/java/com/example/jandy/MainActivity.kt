package com.example.jandy

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jandy.databinding.ActivityMainBinding
import com.example.jandy.fragment.BoardFragment
import com.example.jandy.fragment.HomeFragment
import com.example.jandy.fragment.InfoFragment
import com.example.jandy.fragment.JogFragment
import com.example.jandy.fragment.RankFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        val button = findViewById<Button>(R.id.btn_map)

        button.setOnClickListener {
            val jogFragment = JogFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_home, jogFragment)
                .commit()
        }

        setContentView(binding.root)

        setBottomNavigationView()

        if(savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId= R.id.fragment_home
        }
    }

    fun setBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment()).commit()
                    true
                }
                R.id.fragment_rank -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, RankFragment()).commit()
                    true
                }
                R.id.fragment_board -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, BoardFragment()).commit()
                    true
                }
                R.id.fragment_info -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_container, InfoFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}