package com.example.practicalenoch.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.practicalenoch.fragment.BranchFragment
import com.example.practicalenoch.fragment.IssueFragment

class MyAdapter(
    private val myContext: Context,
    fm: FragmentManager,
    private var totalTabs: Int,
    var branchUrl: String,
    var issueUrl: String
) :
    FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                BranchFragment(branchUrl)
            }
            1 -> {
                IssueFragment(issueUrl)
            }
            else -> getItem(position)
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}