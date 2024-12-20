package com.example.radioactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.radioactivity.databinding.ActivityLoginBinding
import com.example.radioactivity.databinding.ActivityTaskdestinationBinding

class TaskdestinationActivity : AppCompatActivity() {
    lateinit var binding: ActivityTaskdestinationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTaskdestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val picture = String =
            intent::
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}