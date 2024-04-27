package com.example.mobiledevelopmentcourselabapp.presentation.view.second.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.ItemPlayerBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.PlayerUiModel

class PlayerAdapter: RecyclerView.Adapter<PlayerAdapter.PlayerHolder>() {

    private var items: List<PlayerUiModel> = arrayListOf()

    fun updateItems(newItems: List<PlayerUiModel>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player, parent, false)

        return PlayerHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        val player = items[position]
        holder.bind(player)
        holder.setOnClickListener {
            player.isExpanded = !player.isExpanded
            notifyItemChanged(position)
        }
    }

    class PlayerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlayerBinding.bind(itemView)

        fun bind(player: PlayerUiModel) {
            binding.name.text = player.name
            binding.number.text = player.number.toString()

            binding.additionalFields.isVisible = player.isExpanded

            binding.age.text = itemView.context.resources.getString(
                R.string.age_pattern,
                player.age,
                itemView.context.resources.getQuantityText(R.plurals.age, player.age)
            )

            binding.playerPosition.text = player.formattedPosition
            binding.team.text = player.formattedTeam

            Glide
                .with(itemView)
                .load(player.photoUrl)
                .into(binding.icon)

        }

        fun setOnClickListener(action: () -> Unit) {
            binding.root.setOnClickListener { action.invoke() }
        }

    }
}

