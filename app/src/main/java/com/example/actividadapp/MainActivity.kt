package com.example.actividadapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "Cycle APP"
    lateinit var myButton: Button

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

        myButton = findViewById<Button>(R.id.btn_intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Go onStart!")

        myButton.setOnClickListener {
            //Intent de tipo Explicito
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Go onResume!")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Go onPause!")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Go onStop!")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "Go onRestart!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Go onDestroy!")
    }
}