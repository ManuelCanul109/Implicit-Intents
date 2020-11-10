package com.manuelcanul.implicitintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun lanzarActivityEnviarTexto(view: View) {
        val intent = Intent(this, EnviarTextoActivity::class.java)
        startActivity(intent)
    }
    fun realizarEnvioDeImagen(view: View) {
        val intent = Intent(this, RecibirImagenActivity::class.java)
        startActivity(intent)
    }

}