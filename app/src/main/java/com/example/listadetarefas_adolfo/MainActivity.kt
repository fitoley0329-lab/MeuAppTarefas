package com.example.listadetarefas_adolfo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ESSA LINHA ABAIXO PRECISA SER EXATAMENTE ASSIM:
        setContentView(R.layout.activity_main)

        val listaDeTarefas = mutableListOf<String>()
        val campoTarefa = findViewById<EditText>(R.id.editTarefa)
        val botaoAdd = findViewById<Button>(R.id.btnAdicionar)
        val visualizadorLista = findViewById<ListView>(R.id.listaTarefas)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeTarefas)
        visualizadorLista.adapter = adaptador

        botaoAdd.setOnClickListener {
            val texto = campoTarefa.text.toString()
            if (texto.isNotEmpty()) {
                listaDeTarefas.add(texto)
                adaptador.notifyDataSetChanged()
                campoTarefa.text.clear()
                Toast.makeText(this, "Tarefa salva!", Toast.LENGTH_SHORT).show()
            }
        }

        visualizadorLista.setOnItemLongClickListener { _, _, posicao, _ ->
            listaDeTarefas.removeAt(posicao)
            adaptador.notifyDataSetChanged()
            Toast.makeText(this, "Tarefa removida!", Toast.LENGTH_SHORT).show()
            true
        }
    }
}