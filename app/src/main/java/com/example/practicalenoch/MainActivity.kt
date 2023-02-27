package com.example.practicalenoch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.practicalenoch.adapter.RepositoryAdapter
import com.example.practicalenoch.databinding.ActivityMainBinding
import com.example.practicalenoch.model.RepoResponseItem
import com.example.practicalenoch.utils.SharedPreference
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var list: ArrayList<RepoResponseItem?>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickEvents()
    }

    private fun onClickEvents() {
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, AddRepoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setData()
    }

    private fun setData() {
        list = SharedPreference(this).getArrayList("List")
        if (!list.isNullOrEmpty()) {
            binding.llAdd.visibility = View.GONE
            binding.rvRepository.visibility = View.VISIBLE
            val adapter = RepositoryAdapter(list, this)
            binding.rvRepository.adapter = adapter
        } else {
            binding.llAdd.visibility = View.VISIBLE
            binding.rvRepository.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add_action) {
            val intent = Intent(this, AddRepoActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}