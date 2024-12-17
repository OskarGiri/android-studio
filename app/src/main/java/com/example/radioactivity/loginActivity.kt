package com.example.radioactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.radioactivity.databinding.ActivityLoginBinding

class loginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            val username: String = binding.editTextText.text.toString()
            val password: String = binding.editTextText2.text.toString()

            if (username.isEmpty()) {
                binding.editTextText.error = "User name can't be empty"
            } else if (password.isEmpty()) {
                binding.editTextText2.error = "password can't be empty"
            } else {

                val intent = Intent(
                    this@loginActivity,
                    DestinationActivity::class.java
                )
                intent.putExtra("username",username)
                intent.putExtra("password",password)

                startActivity(intent)
                finish()
            }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}