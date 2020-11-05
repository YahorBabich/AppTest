package com.task.app.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.app.R
import com.task.app.data.Team
import com.task.app.databinding.ActivityListBinding
import com.task.app.extention.observe
import com.task.app.ui.details.DetailsActivity
import com.task.app.ui.details.DetailsActivity.Companion.KEY_DETAILS
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListActivity : AppCompatActivity(), ListAdapter.ListListener {

    private val viewModel by viewModel<ListViewModel>()

    private val adapter = ListAdapter(this)
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        viewModel.apply {
            observe(teamsData, ::showProducts)
        }

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
        viewModel.getList()
    }

    private fun showProducts(teams: List<Team>?) {
        teams?.apply {
            adapter.setTeams(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.by_name -> viewModel.sortBy(Sort.NAME)
            R.id.by_wins -> viewModel.sortBy(Sort.WINS)
            R.id.by_losses -> viewModel.sortBy(Sort.LOSSES)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun openDetails(id: Int) {
        startActivity(Intent(this, DetailsActivity::class.java).apply {
            putExtra(KEY_DETAILS, id)
        })
    }
}