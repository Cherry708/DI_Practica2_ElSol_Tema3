package com.example.di_practica2_elsol_tema3

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class ItemCardAdapter(var listaItems: ArrayList<ItemCard>) : RecyclerView.Adapter<ItemCardAdapter.ItemViewHolder>() {
    lateinit var onClick : (View) -> Unit


    //La clase declarada como itemViewHolder hereda, es, un ViewHolder
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var menuToolbar: Toolbar
        private var imagen: ImageView

        init {
            menuToolbar = itemView.findViewById(R.id.tbToolbar)
            imagen = itemView.findViewById(R.id.ivImage)

            menuToolbar.inflateMenu(R.menu.menu_card)
        }

        fun bindTarjeta(item: ItemCard, onClick: (View) -> Unit) = with(itemView) {
            menuToolbar.setTitle(item.titulo)

            imagen.setImageResource(item.imagen)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card, viewGroup, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, pos: Int) {
        val itemCard = listaItems.get(pos)
        viewHolder.bindTarjeta(itemCard, onClick)

        viewHolder.menuToolbar.setOnMenuItemClickListener(object: Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem): Boolean{
                when(item.itemId){
                    (R.id.action_copiar) ->{
                        listaItems.add(viewHolder.adapterPosition, ItemCard(itemCard.imagen,itemCard.titulo))
                        notifyItemInserted(viewHolder.adapterPosition)
                    }
                    (R.id.action_eliminar) ->{
                        listaItems.removeAt(viewHolder.adapterPosition)
                        notifyItemRemoved(viewHolder.adapterPosition)
                    }
                }
                return true
            }

        })
    }

    override fun getItemCount(): Int {
        return listaItems.size
    }
}

