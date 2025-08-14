package com.example.calcularmedia

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun calcularMedia(view: View){

        val editNota1 = findViewById<EditText>(R.id.editNota1)
        val editNota2 = findViewById<EditText>(R.id.editNota2)
        val editNota3 = findViewById<EditText>(R.id.editNota3)

        val textMedia = findViewById<TextView>(R.id.textMedia)
        val textStatus = findViewById<TextView>(R.id.textStatus)

        val nota1 = editNota1.getText().toString()
        val nota2 = editNota2.getText().toString()
        val nota3 = editNota3.getText().toString()

        val nota1Convertido: Double = nota1.toDouble()
        val nota2Convertido: Double = nota2.toDouble()
        val nota3Convertido: Double = nota3.toDouble()

        val media = (nota1Convertido + nota2Convertido + nota3Convertido)/3

        textMedia.setText("Media: $media")

        if(media >= 6){
            textStatus.setText("Aprovado!")
            textStatus.setTextColor(Color.GREEN)
        }else{
            textStatus.setText("Reprovado!")
            textStatus.setTextColor(Color.RED)
        }



    }
}