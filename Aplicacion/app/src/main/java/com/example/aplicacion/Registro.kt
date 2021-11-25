package com.example.aplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Registro : AppCompatActivity() {
    private lateinit var ed_Nombres:EditText
    private lateinit var ed_Apellidos:EditText
    private lateinit var ed_NombreUsuario:EditText
    private lateinit var btnContinuar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        ed_Nombres = findViewById(R.id.ed_Nombres)
        ed_Apellidos = findViewById(R.id.ed_Apellidos)
        ed_NombreUsuario = findViewById(R.id.ed_NombreUsuario)
        btnContinuar = findViewById(R.id.btnContinuar)

        val actionBar = supportActionBar
        actionBar!!.title = "Resgistro"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}