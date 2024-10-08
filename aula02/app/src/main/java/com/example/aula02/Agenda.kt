package com.example.aula02

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

data class Contato(
    var nome : String = "",
    var telefone : String = "",
    var email : String = ""
)

class Agenda : Activity() {
    val lista = ArrayList<Contato>()
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_main)

        val edtNome : EditText = findViewById(R.id.edt_nome)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtTelefone = findViewById<EditText>(R.id.edt_telefone)

        val btnGravar = findViewById<Button>(R.id.btn_gravar)
        val btnPesquisar = findViewById<Button>(R.id.btn_pesquisar)

        btnGravar.setOnClickListener {
            val contato = Contato(
                nome = edtNome.text.toString(),
                telefone = edtTelefone.text.toString(),
                email = edtEmail.text.toString()
            )
            lista.add( contato )

            Toast.makeText(this,
                "Contato gravado com sucesso", Toast.LENGTH_LONG).show()
            edtNome.setText("")
            edtTelefone.setText("")
            edtEmail.setText("")
        }

        btnPesquisar.setOnClickListener {
            for (contato in lista) {
                if (contato.nome.contains( edtNome.text )) {
                    edtNome.setText(contato.nome)
                    edtTelefone.setText(contato.telefone)
                    edtEmail.setText(contato.email)
                    break
                }
            }
        }
    }
}