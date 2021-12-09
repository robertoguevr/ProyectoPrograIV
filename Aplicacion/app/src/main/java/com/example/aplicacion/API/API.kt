package com.example.aplicacion.API
import com.android.volley.Response
import com.example.aplicacion.Modelos.*
import retrofit2.http.*

interface API {
    @POST("Usuarios/NuevoUsaurio")
    suspend fun nuevoRegistro(@Body usuarios:Usuarios)

    @GET("Usuarios/checkUser/{user}/{pass}")
    suspend fun loginUser(@Path("usuario") usuario:String, @Path("clave") clave:String): Response<Boolean>

    @GET("Usuarios/checkUserIfExists/{user}")
    suspend fun verifyUser(@Path("usuario") usuario: String):Response<Boolean>

    @GET("Usuarios/returnTypeAccess/{user}/{pass}")
    suspend fun returnTypeUser(@Path("usuario") usuario:String, @Path("clave") pass:String):Response<List<Usuarios>>
}