package com.example.radioactivity.ui.activity

import android.app.FragmentTransaction
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.radioactivity.R
import com.example.radioactivity.databinding.ActivityHomeBinding
import com.example.radioactivity.databinding.ActivityTaskBinding
import com.example.radioactivity.ui.fragment.firstFragment
import com.example.radioactivity.ui.fragment.secondFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button4.setOnClickListener{
            replaceFrag(firstFragment())
        }
        binding.button5.setOnClickListener {
            replaceFrag(secondFragment())
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFrag(fragment: Fragment) {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction:androidx.fragment.app.FragmentTransaction= fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame, fragment)
            fragmentTransaction.commit()
        }
    }

