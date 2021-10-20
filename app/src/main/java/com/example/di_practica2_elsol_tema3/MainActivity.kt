package com.example.di_practica2_elsol_tema3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaItems = ArrayList<ItemCard>()
        listaItems.add(ItemCard(R.drawable.corona_solar,R.string.card0))
        listaItems.add(ItemCard(R.drawable.erupcionsolar,R.string.card1))
        listaItems.add(ItemCard(R.drawable.espiculas,R.string.card2))
        listaItems.add(ItemCard(R.drawable.filamentos,R.string.card3))
        listaItems.add(ItemCard(R.drawable.magnetosfera,R.string.card4))
        listaItems.add(ItemCard(R.drawable.manchasolar,R.string.card5))



        val recView = findViewById<RecyclerView>(R.id.rvCards)

        recView.setHasFixedSize(true)


        val adaptador = ItemCardAdapter(listaItems)
        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(this,2)
        recView.itemAnimator = DefaultItemAnimator()

        adaptador.onClick = {
        }
    }
}