package com.example.radioactivity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listactivity : AppCompatActivity() {
    lateinit var listView: ListView
    var contact = arrayOf(
        "oskar", "sandip", "sita", "gita",
        "oskar", "sandip", "sita", "gita",
        "oskar", "sandip", "sita", "gita"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listactivity)

        listView = findViewById(R.id.list)

        val adapter = ArrayAdapter(
            this@listactivity,
            android.R.layout.simple_list_item_1,
            contact
        )
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, p1, position, l ->
            if (parent != null) {
                Toast.makeText(
                    this@listactivity,
                    parent.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}