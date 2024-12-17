package com.example.radioactivity

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.MultiAutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.DayOfWeek
import java.time.Month
import java.util.Date

class SignupactivityActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener{
    lateinit var  Spinner: Spinner
    lateinit var  textView: TextView
    lateinit var  autoCompleteTextView: AutoCompleteTextView
    lateinit var  Date: EditText

    var countries = arrayOf(
        "Nepal","china","India","usa","canada"
    )
    var Cities = arrayOf("Janapur","Kathamandu","Jhapa","Bhakatapur","Lalitpur")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.signupactivity)
        Spinner = findViewById<Spinner>(R.id.spinner)
        textView = findViewById(R.id.textView3)
        Date = findViewById(R.id.Date)

        Date.isClickable=true
        Date.isFocusable =false

        Date.setOnClickListener{
            loadCalendar()


        }

        autoCompleteTextView=findViewById(R.id.autoCompleteTextView)
        val  autoAdapter = ArrayAdapter(
                 this@SignupactivityActivity,
             android.R.layout.simple_list_item_1,
            Cities
)
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold=1
        val adapter = ArrayAdapter (
            this@SignupactivityActivity,
            android.R.layout.simple_list_item_1,
            countries


            )
        adapter.setDropDownViewResource(
            android.R.layout.simple_list_item_1
        )
        Spinner.adapter = adapter
        Spinner.onItemSelectedListener = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar() {
        val c = Calendar.getInstance()
        val  Year = c.get(Calendar.YEAR)
        val  Month = c.get(Calendar.MONTH)
        val  Day = c.get(Calendar.DAY_OF_MONTH)

        val  dialog = DatePickerDialog(
              this@SignupactivityActivity,
            { datePicker,Year,Month,Day->
               Date.setText("$Year/${Month+1}/$Day")
            },Year,Month,Day
        )
        dialog.show()

    }


    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, id: Long) {
        if (parent!=null){
            textView.text ="You have selected :"+parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}