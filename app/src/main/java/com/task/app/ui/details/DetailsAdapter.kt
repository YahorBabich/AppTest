package com.task.app.ui.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.app.data.Player
import com.task.app.databinding.ViewDetailsItemBinding
import kotlinx.android.synthetic.main.view_details_item.view.*
import kotlinx.android.synthetic.main.view_list_item.view.name

@SuppressLint("SetTextI18n")
class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.ListViewHolder>() {

    private val players = mutableListOf<Player>()

    fun setPlayers(players: List<Player>) {
        this.players.apply {
            clear()
            addAll(players)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ViewDetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = players.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(players[position])
    }

    inner class ListViewHolder(binding: ViewDetailsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player) {
            itemView.apply {
                name.text = "${player.first_name} ${player.last_name}"
                pos.text = "P: ${player.position}"
                number.text = "Number: ${player.number}"
            }
        }
    }
}