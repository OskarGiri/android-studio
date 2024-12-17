package com.example.radioactivity

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class alert : AppCompatActivity() {
    lateinit var buttonAlert: Button
    lateinit var buttonSnack: Button
    lateinit var buttonToast: Button
    lateinit var  main: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_alert)
        buttonAlert= findViewById(R.id.Alert)
        buttonSnack= findViewById(R.id.snack)
        buttonToast= findViewById(R.id.Toast)
        main = findViewById(R.id.main)


        buttonToast.setOnClickListener{
            Toast.makeText(
                this@alert,
                "Invalid Login details",
                Toast.LENGTH_LONG
            ).show()
        }
        buttonSnack.setOnClickListener{
            Snackbar.make(main,
                "NO Internet Connection",
                Snackbar.LENGTH_LONG).setAction("Retry", {
            }).show()
        }
        buttonAlert.setOnClickListener{
            val alert = AlertDialog.Builder(this@alert)
            alert.setTitle("Confirm")
                .setMessage("Are you sure")
                .setIcon(R.drawable.zoro)
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                .setNegativeButton("NO",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                }).show()



        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}