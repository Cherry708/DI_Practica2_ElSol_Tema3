package com.example.di_practica2_elsol_tema3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class ItemCardAdapter(var items: ArrayList<ItemCard>) : RecyclerView.Adapter<ItemCardAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit


    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var titulo: Toolbar
        private var imagen: ImageView

        init {
            titulo = itemView.findViewById(R.id.tbToolbar)
            imagen = itemView.findViewById(R.id.ivImage)

            titulo.inflateMenu(R.menu.menu_card)
        }

        fun bindTarjeta(item: ItemCard, onClick: (View) -> Unit) = with(itemView) {
            titulo.setTitle(item.titulo)

            imagen.setImageResource(item.imagen)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

