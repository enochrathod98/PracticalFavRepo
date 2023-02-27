package com.example.practicalenoch.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicalenoch.CommitScreenActivity
import com.example.practicalenoch.R
import com.example.practicalenoch.model.BranchResponseItem
import com.example.practicalenoch.model.IssueResponseItem

class IssueAdapter(
    private val issueList: List<IssueResponseItem>,
    val context: Context
) :
    RecyclerView.Adapter<IssueAdapter.IssueViewHolder>() {

    class IssueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.branch_data_layout, parent, false)
        return IssueViewHolder(view)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val data: IssueResponseItem = issueList[position]
        holder.name.text = data.issue!!.title
    }

    override fun getItemCount(): Int {
        return issueList.size
    }
}