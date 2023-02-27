package com.example.practicalenoch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.practicalenoch.adapter.MyAdapter
import com.example.practicalenoch.databinding.ActivityDetailScreenBinding
import com.example.practicalenoch.model.RepoResponseItem
import com.example.practicalenoch.utils.SharedPreference
import com.google.android.material.tabs.TabLayout

class DetailScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailScreenBinding
    var name = ""
    var description = ""
    var branchUrl = ""
    var issueUrl = ""
    var openIssueCount = ""
    var url = ""
    var list: ArrayList<RepoResponseItem?>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.title = "Details"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        if (intent.hasExtra("name")) {
            name = intent.getStringExtra("name").toString()
        }
        if (intent.hasExtra("description")) {
            description = intent.getStringExtra("description").toString()
        }
        if (intent.hasExtra("branch_url")) {
            branchUrl = intent.getStringExtra("branch_url").toString()
        }
        if (intent.hasExtra("issue_url")) {
            issueUrl = intent.getStringExtra("issue_url").toString()
        }
        if (intent.hasExtra("url")) {
            url = intent.getStringExtra("url").toString()
        }
        if (intent.hasExtra("issue_count")) {
            openIssueCount = intent.getStringExtra("issue_count").toString()
            if (openIssueCount.isNullOrEmpty()) {
                openIssueCount = "0"
            }
        }

        binding.tvName.text = name
        binding.tvDec.text = description

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Branch"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Issue ($openIssueCount)"))
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter =
            MyAdapter(this, supportFragmentManager, binding.tabLayout.tabCount, branchUrl, issueUrl)
        binding.viewPager.adapter = adapter

        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete) {
            deleteItem()
        } else if (item.itemId == R.id.web) {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteItem() {
        list = SharedPreference(this).getArrayList("List")
        if (!list.isNullOrEmpty()) {
            for (i in list!!.indices) {
                if (list!![i]!!.name == name) {
                    list!!.removeAt(i)
                    SharedPreference(this).saveArrayList(list, "List")
                    finish()
                }
            }
        }
    }
}