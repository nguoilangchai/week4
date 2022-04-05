package com.example.baitaptuan3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.baitaptuan3.model.Restaurant

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.IdolViewHolder>(IdolDiffUtil()) {

    class IdolDiffUtil : DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdolViewHolder {
        return IdolViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: IdolViewHolder, position: Int) {
        val idol = getItem(position)
        holder.bindData(idol)
    }


    class IdolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object{
            fun from(parent: ViewGroup) : IdolViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_view_restaurant, parent, false)
                return IdolViewHolder(view)
            }
        }

        fun bindData(idol : Restaurant){
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
            val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)
            val ivAvatar = itemView.findViewById<ImageView>(R.id.imageView)

            tvTitle.text = idol.name
            tvDescription.text = idol.address
            ivAvatar.setImageResource(idol.avatar)
        }
    }



}