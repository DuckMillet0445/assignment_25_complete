package com.example.assignment_25.home.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_25.auth.Entity
import com.example.assignment_25.databinding.ItemEntityBinding

// Adapter for displaying a list of entities in a RecyclerView
class EntityAdapter(private val onItemClick: (Entity) -> Unit) :
    ListAdapter<Entity, EntityAdapter.EntityViewHolder>(EntityDiffCallback()) {

    // Creates a new ViewHolder for an entity item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val binding = ItemEntityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntityViewHolder(binding, onItemClick)
    }

    // Binds data to the ViewHolder
    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    // ViewHolder class for entity items
    class EntityViewHolder(
        private val binding: ItemEntityBinding,
        private val onItemClick: (Entity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        // Binds the entity data to the UI components
        fun bind(entity: Entity) {
            binding.dishNameTextView.text = entity.dishName ?: "N/A"
            binding.originTextView.text = entity.origin ?: "N/A"
            binding.mainIngredientTextView.text = entity.mainIngredient ?: "N/A"
            binding.mealTypeTextView.text = entity.mealType ?: "N/A"
            binding.descriptionTextView.text = entity.description ?: "N/A"
            binding.root.setOnClickListener { onItemClick(entity) }
        }
    }

    class EntityDiffCallback : DiffUtil.ItemCallback<Entity>() {
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem.dishName == newItem.dishName // Assuming dishName is unique
        }

        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem == newItem
        }
    }
}