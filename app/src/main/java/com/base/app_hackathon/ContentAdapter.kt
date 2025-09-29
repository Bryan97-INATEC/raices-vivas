package com.base.app_hackathon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContentAdapter(private val items: List<ContentItem>, private val tipo: String ) :
    RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val title: TextView = itemView.findViewById(R.id.item_title)
        val description: TextView = itemView.findViewById(R.id.item_description)
        val button: Button = itemView.findViewById(R.id.item_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.imageRes)
        holder.title.text = item.title
        holder.description.text = item.description

        holder.button.setOnClickListener {
            val context = holder.itemView.context
            val intent = when (tipo) {
                "relato" -> when (position) {
                    0 -> Intent(context, Login_1::class.java)
                    else -> Intent(context, Login_1::class.java)
                }
                else -> null
            }

            intent?.let { context.startActivity(it) }
        }
    }

    override fun getItemCount(): Int = items.size
}