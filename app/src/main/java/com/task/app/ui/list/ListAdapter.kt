package com.task.app.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.app.data.Team
import com.task.app.databinding.ViewListItemBinding
import kotlinx.android.synthetic.main.view_list_item.view.*

class ListAdapter(val listener: ListListener) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val teams = mutableListOf<Team>()

    fun setTeams(teams: List<Team>) {
        this.teams.apply {
            clear()
            addAll(teams)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ViewListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = teams.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    inner class ListViewHolder(binding: ViewListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team) {
            itemView.apply {
                name.text = team.full_name
                wins.text = team.wins.toString()
                losses.text = team.losses.toString()

                setOnClickListener {
                    listener.openDetails(team.id)
                }
            }
        }
    }

    interface ListListener {
        fun openDetails(id: Int)
    }
}