package com.task.app.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.app.data.Team
import com.task.app.databinding.ActivityDetailsBinding
import com.task.app.extention.extra
import com.task.app.extention.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private val viewModel by viewModel<DetailsViewModel>()

    private lateinit var binding: ActivityDetailsBinding

    private val teamId by extra<Int>(KEY_DETAILS)
    private val adapter = DetailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        viewModel.apply {
            observe(teamData, ::showTeam)
        }

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
        teamId?.apply {
            viewModel.getDetailsById(this)
        }
    }

    private fun showTeam(team: Team?) {
        team?.apply {
            binding.name.text = full_name
            binding.losses.text = losses.toString()
            binding.wins.text = wins.toString()
            adapter.setPlayers(players)
        }
    }


    companion object {
        const val KEY_DETAILS = "KEY_DETAILS"
    }

}