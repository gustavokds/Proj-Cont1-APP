package com.example.continuada1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(componente:View){
        if (et_nome.text.toString().equals("") || et_media01.text.toString().equals("") || et_media02.text.toString().equals("") || et_media03.text.toString().equals("") || et_mediaGeral.text.equals("")){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }else {
            val mediaGeral = et_mediaGeral.text.toString().toDouble();
            val nome = et_nome.text.toString();
            val soma = (et_media01.text.toString().toDouble()) + (et_media02.text.toString()
                .toDouble()) + (et_media03.text.toString().toDouble())
            val objetivo = mediaGeral * 4
            val nota = objetivo - soma
            var frase: String
            if (soma > objetivo) {
                frase =
                    "Uau! $nome é um aluno exemplar e já tem nota para passar de ano. Sua Soma: $soma"
                tv_resultado.setTextColor(Color.GREEN)
            } else if (nota > 10) {
                frase =
                    "$nome infelizmente você ja está de recuperação mas tente tirar o máximo de nota possivel neste semestre. Você precisa de ${objetivo - soma}"
                tv_resultado.setTextColor(Color.RED)
            } else if (nota >= mediaGeral && nota <= 10) {
                frase = "$nome voce precisa de $nota para passar sem recuperação."
                tv_resultado.setTextColor(Color.YELLOW)
            } else {
                frase = "$nome falta pouco, você precisa de apenas $nota para passar."
                tv_resultado.setTextColor(Color.CYAN)
            }
            tv_resultado.text = frase.toString()
            tv_resultado.visibility = View.VISIBLE
        }
    }
}