package com.example.di_practica2_elsol_tema3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.di_practica2_elsol_tema3.databinding.ActivityCompararPlanetasBinding

class CompararPlanetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_planetas)

        val binding = ActivityCompararPlanetasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaPlanetas = ArrayList<String>()
        listaPlanetas.add("Mercurio")
        listaPlanetas.add("Venus")
        listaPlanetas.add("Tierra")
        listaPlanetas.add("Marte")
        listaPlanetas.add("Jupiter")
        listaPlanetas.add("Saturno")
        listaPlanetas.add("Urano")
        listaPlanetas.add("Neptuno")
        listaPlanetas.add("Pluton")

        val listaDiametros = ArrayList<String>()
        listaDiametros.add("0,382")
        listaDiametros.add("0,949")
        listaDiametros.add("1")
        listaDiametros.add("0,53")
        listaDiametros.add("11,2")
        listaDiametros.add("9,41")
        listaDiametros.add("3,38")
        listaDiametros.add("3,81")
        listaDiametros.add("???")

        val listaDistanciasAlSol = ArrayList<String>()
        listaDistanciasAlSol.add("0,387")
        listaDistanciasAlSol.add("0,723")
        listaDistanciasAlSol.add("1")
        listaDistanciasAlSol.add("1,542")
        listaDistanciasAlSol.add("5,203")
        listaDistanciasAlSol.add("9,539")
        listaDistanciasAlSol.add("19,81")
        listaDistanciasAlSol.add("30,07")
        listaDistanciasAlSol.add("39,44")

        val listaDensidades = ArrayList<String>()
        listaDensidades.add("5400")
        listaDensidades.add("5250")
        listaDensidades.add("5520")
        listaDensidades.add("3960")
        listaDensidades.add("1350")
        listaDensidades.add("700")
        listaDensidades.add("1200")
        listaDensidades.add("1500")
        listaDensidades.add("5?")


        val adaptador = ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, listaPlanetas)

        binding.actvPlaneta0.setAdapter(adaptador)
        binding.actvPlaneta0.threshold = 1

        binding.actvPlaneta1.setAdapter(adaptador)
        binding.actvPlaneta1.threshold = 1

        binding.actvPlaneta0.setOnItemClickListener{ adaptadorItem: AdapterView<*>, viewItem: View,
                                                     posicion: Int, l: Long ->
            val itemPlaneta = adaptadorItem.getItemAtPosition(posicion) as String
            for (planeta in listaPlanetas){
                if (itemPlaneta == planeta) {
                    binding.tvDiametroPlaneta0.text = (listaDiametros[(listaPlanetas.indexOf(planeta))])
                    binding.tvDistanciaPlaneta0.text = (listaDistanciasAlSol[listaPlanetas.indexOf(planeta)])
                    binding.tvDensidadPlaneta0.text = (listaDensidades[(listaPlanetas.indexOf(planeta))])
                }
            }
        }
        binding.actvPlaneta1.setOnItemClickListener{ adaptadorItem: AdapterView<*>, viewItem: View,
                                                     posicion: Int, l: Long ->
            val itemPlaneta = adaptadorItem.getItemAtPosition(posicion) as String
            for (planeta in listaPlanetas)
                if (itemPlaneta == planeta){
                    binding.tvDiametroPlaneta1.text = (listaDiametros[(listaPlanetas.indexOf(planeta))])
                    binding.tvDistanciaPlaneta1.text = (listaDistanciasAlSol[listaPlanetas.indexOf(planeta)])
                    binding.tvDensidadPlaneta1.text = (listaDensidades[(listaPlanetas.indexOf(planeta))])
                }
        }

    }
}