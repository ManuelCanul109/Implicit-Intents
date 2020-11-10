package com.manuelcanul.implicitintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EnviarTextoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_texto)
        // finding the button
        val btnTexto = findViewById<Button>(R.id.btnEnviarTexto)

        // finding the edit text
        val etTexto = findViewById<EditText>(R.id.etTextoAEnviar)

        btnTexto.setOnClickListener {
            val msg: String = etTexto.text.toString()

            //check if the EditText have values or not
            if(msg.trim().isNotEmpty()) {
                Toast.makeText(applicationContext, "Mensaje : "+msg, Toast.LENGTH_SHORT).show()
                realizarEnvioDeTexto(msg)
            }else{
                Toast.makeText(applicationContext, "Ingrese un mensaje, por favor! ", Toast.LENGTH_SHORT).show()
            }
        }

        val isActivityLaunchedFromActionSend = intent?.action == Intent.ACTION_SEND
        val isTextData = intent.type?.startsWith("text/") == true

        if (isActivityLaunchedFromActionSend  && isTextData) {
            // Session 1: Handle received text data
            val sentString = intent.getStringExtra(Intent.EXTRA_TEXT)
            etTexto.setText(sentString)
        }
    }

    fun realizarEnvioDeTexto(textoaenviar: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textoaenviar)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}