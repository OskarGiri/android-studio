package com.example.radioactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.radioactivity.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener,
    AdapterView.OnItemClickListener {
    lateinit var  binding: ActivityTaskBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button3.setOnClickListener {
            val checkBox : String = binding.checkBox2.text.toString()
            if (checkBox.isBlank()){
                binding.checkBox2.error ="Please click on I agree"
            } else{
                binding.checkBox2.text ="Please click on I agree"
            }
            val intent = Intent(
                this@TaskActivity,
                TaskdestinationActivity::class.java

            )
            intent.putExtra("photo",binding.imageView2)



        }
        val countries= arrayOf(
            "Nepal","China","India","Usa","Canada"
        )

            val adapter = ArrayAdapter(
                this@TaskActivity,
                android.R.layout.simple_list_item_1,
                countries
            )
            binding.spinner2.adapter = adapter
            binding.spinner2.onItemSelectedListener = this




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent!=null) {
          binding.textView7.text = "You have selected:"+parent.getItemAtPosition(position).toString()

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }
}