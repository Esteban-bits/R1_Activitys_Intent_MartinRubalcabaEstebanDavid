package com.example.actividadapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "Cycle APP"
    lateinit var myButton: Button
    lateinit var myEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i(TAG, "Go onCreate!")

        myButton = findViewById(R.id.btn_intent)
        myEdit = findViewById(R.id.editText)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Go onStart!")

        myButton.setOnClickListener {
            val dato = myEdit.text.toString().trim()

            if (dato.isEmpty()) {
                myEdit.error = "Debes Ingresar tu nombre."
            } else {
                val intent = Intent(this, Activity2::class.java).apply {
                    putExtra("dato", dato)
                }
                startActivity(intent)
            }
        }
    }
}