package com.example.aplicacion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception


    class MainActivity : AppCompatActivity() {
        private lateinit var edUsuario:EditText
        private lateinit var edClave: EditText

    //Datos de usuarios para el logueo que estan estaticos
    var usu1= arrayOf("Dayana","Castro","daya","1234")
    var usu2= arrayOf("Ronald","Figueroa","ronald","1234")
    var usu3= arrayOf("Marcos","Miranda","marcos","1234")
    var usu4= arrayOf("Milton","Barrera","mil","1234")
    var usu5= arrayOf("Enmanuel","Orellana","enma","1234")
     var usu6= arrayOf("Roberto", "Mario", "roberto","1234")

    //variable para inicio de sesion
    var cred= arrayListOf(usu1,usu2,usu3,usu4,usu5, usu6)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Asignando los componentes a las variables
        edUsuario=findViewById(R.id.edUsuario)
        edClave=findViewById(R.id.edClave)

        //Recogiendo datos del Intent
        val miIntent=intent.extras
        val nombre=miIntent?.getString("nombre").toString()
        val apellido=miIntent?.getString("apellido").toString()
        val usuario=miIntent?.getString("usu").toString()
        val clave=miIntent?.getString("clave").toString()
        if(nombre!="null"&&apellido!="null"&&usuario!="null"&&clave!="null"){
            val newUser= arrayOf(nombre,apellido,usuario,clave)
            cred.add(newUser)
        }
        cred.forEach { println(it.get(1)) }
    }
    //Funcion para evaluar si hay registro de credenciales
    fun evalCredentials(view: View){
        var result=false
        var contador=0
        cred.forEach{
            result = edUsuario.text.toString().equals(it.get(1)) && edClave.text.toString().equals(it.get(3))
            if (result) contador=1
        }
        if(contador==1){
            startActivity(Intent(this,ActivityInicio::class.java))
            contador=0
        }else {
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_LONG).show()
        }
    }
    //Conexion a base de datos
    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("http://192.168.1.10:8080/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Funcion para ir al Registro
    fun onLoginClick(view: View?) {
        startActivity(Intent(this, NuevoUsuario::class.java))
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
    }