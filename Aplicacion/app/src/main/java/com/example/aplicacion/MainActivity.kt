package com.example.aplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    private lateinit var ed_Username:EditText
    private lateinit var ed_Password:EditText
    private lateinit var loginbtn :Button
    private lateinit var registrarse:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_Username = findViewById(R.id.ed_Username)
        ed_Password = findViewById(R.id.ed_Password)
        loginbtn = findViewById(R.id.loginbtn)
        registrarse = findViewById(R.id.registrarse)

        //Abrir activity de Registro
        registrarse.setOnClickListener{
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }

    }
}