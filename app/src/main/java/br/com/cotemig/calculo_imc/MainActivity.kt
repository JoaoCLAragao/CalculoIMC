package br.com.cotemig.calculo_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalcula = findViewById<Button>(R.id.btnCalculaIMC)

        btnCalcula.setOnClickListener {
            calculaIMC()
        }
    }

    // massa / altura²
    fun calculaIMC() {
        var resultadoIMC = findViewById<TextView>(R.id.textViewResultadoIMC)
        var resultadoSituacao = findViewById<TextView>(R.id.textViewResultadoSituacao)
        var massa = findViewById<EditText>(R.id.editTextKG).text.toString().toDouble()
        var altura = findViewById<EditText>(R.id.editTextCM).text.toString().toDouble()
        var imc : Double

        imc = massa / (altura * altura)
        if (imc > 40) {
            resultadoIMC.text = imc.toString()
            resultadoSituacao.text = resources.getString(R.string.obesidade_3)
        } else if (imc >= 35) {
            resultadoIMC.text = imc.toString()
            resultadoSituacao.text = resources.getString(R.string.obesidade_2)
        } else if (imc >= 30) {
            resultadoIMC.text = imc.toString()
            resultadoSituacao.text = resources.getString(R.string.obesidade_1)
        } else if (imc >= 25) {
            resultadoIMC.text = imc.toString()
            resultadoSituacao.text = resources.getString(R.string.acima_do_peso)
        } else if (imc >= 18.5) {
            resultadoIMC.text = imc.toString()
            resultadoSituacao.text = resources.getString(R.string.peso_normal)
        } else if (imc >= 17) {
            resultadoIMC.text = imc.toString()
            resultadoSituacao.text = resources.getString(R.string.abaixo_do_peso)
        } else {
            resultadoIMC.text = imc.toString()
            resultadoSituacao.text = resources.getString(R.string.muito_abaixo_do_peso)
        }
    }
}