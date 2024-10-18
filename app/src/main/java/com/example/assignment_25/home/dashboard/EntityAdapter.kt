package com.example.assignment_25.home.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_25.auth.Entity
import com.example.assignment_25.databinding.ItemEntityBinding

class EntityAdapter(private val onItemClick: (Entity) -> Unit) :
    ListAdapter<Entity, EntityAdapter.EntityViewHolder>(EntityDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val binding = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntityViewHolder(binding, onItemClick)
    }


    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class EntityViewHolder(
        private val binding: ItemEntityBinding,
        private val onItemClick: (Entity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(entity: Entity) {
            binding.property1TextView.text = entity.property1
            binding.property2TextView.text = entity.property2
            binding.root.setOnClickListener { onItemClick(entity) }
        }
    }


    class EntityDiffCallback : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.property1 == newItem.property1 // Assuming property1 is unique
        }


        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem == newItem
        }
    }
}
