package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val items:List<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val nameTextView: TextView
        val urlTextView: TextView
        val priceTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.wishlistItemName)
            urlTextView = itemView.findViewById(R.id.wishListURL)
            priceTextView = itemView.findViewById(R.id.wishListPrice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val itemView = inflater.inflate(R.layout.wishlist_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.nameTextView.text = item.name
        holder.urlTextView.text = item.store
        holder.priceTextView.text = item.price.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}