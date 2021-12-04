package com.example.aplicacion
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class NuevoUsuario : AppCompatActivity(){

// Creando las variables para los objetos
    private lateinit var edNombre:EditText
    private lateinit var edApellido:EditText
    private lateinit var edUsuarioRegistro:EditText
    private lateinit var edEdad: EditText
    private lateinit var edClaveRegistro: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        // Asignando los objetos a las variables
        edNombre=findViewById(R.id.edNombre)
        edApellido=findViewById(R.id.edApellido)
        edEdad=findViewById(R.id.edEdad)
        edUsuarioRegistro=findViewById(R.id.edUsuarioRegistro)
        edClaveRegistro=findViewById(R.id.edClaveRegistro)
    }
    // Funcion para guardar
    fun saveUser(view: View?) {
        //variables contenedoras del texto de los campos
        var nombre=edNombre.text.toString()
        var apellido=edApellido.text.toString()
        var usuarioRegistro=edUsuarioRegistro.text.toString()
        var claveRegistro=edClaveRegistro.text.toString()

        // Evaluando si estan vacias
        if (! nombre.isEmpty()&&! apellido.isEmpty()&&! usuarioRegistro.isEmpty()&&! claveRegistro.isEmpty()){
            var nuevoUsu2= arrayOf(nombre,apellido,usuarioRegistro,claveRegistro)
            Toast.makeText(this,"Usuario Registrado",Toast. LENGTH_LONG).show()
            val inten=Intent(this,MainActivity::class.java)
            inten.putExtra("nombre",nombre)
            inten.putExtra("apellido",apellido)
            inten.putExtra("usuarioRegistro",usuarioRegistro)
            inten.putExtra("claveRegistro",claveRegistro)
            startActivity(inten)
        }else{
            Toast.makeText(this,"Debe completar los campos",Toast. LENGTH_LONG).show()
        }
    }

    // Funcion para regresar a la vista anterior
    fun onLoginClick(view: View?) {
        startActivity(Intent(this,MainActivity::class.java))
        overridePendingTransition(R.anim.slide_in_right,android. R.anim.slide_out_right);
    }
}