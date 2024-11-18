package com.example.radioactivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Radioactivity : AppCompatActivity() {
    lateinit var Luffy :RadioButton
    lateinit var Zoro:RadioButton
    lateinit var Sanji:RadioButton
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Luffy=findViewById(R.id.radioluffy)
        Zoro = findViewById(R.id.radiozoro)
        Sanji = findViewById(R.id.radiosanji)
        image = findViewById(R.id.imageView)

        Luffy.setOnClickListener{
            image.setImageResource(R.drawable.luffy)
        }
        Zoro.setOnClickListener{
            image.setImageResource(R.drawable.zoro)
        }
        Sanji.setOnClickListener{
            image.setImageResource(R.drawable.sanji)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}