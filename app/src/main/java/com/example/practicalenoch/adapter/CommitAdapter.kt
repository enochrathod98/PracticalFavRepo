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
import com.example.practicalenoch.model.CommitResponse

class CommitAdapter(
    private val commitList: List<CommitResponse>,
    val context: Context
) :
    RecyclerView.Adapter<CommitAdapter.CommitViewHolder>() {

    class CommitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView = itemView.findViewById(R.id.tv_date)
        var comment: TextView = itemView.findViewById(R.id.tv_comment)
        var name: TextView = itemView.findViewById(R.id.tv_userName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.commit_data_layout, parent, false)
        return CommitViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
        val data: CommitResponse = commitList[position]
        holder.date.text = data.commit?.author?.date
        holder.comment.text = data.commit?.message
        holder.name.text = data.committer?.login.toString()
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CommitScreenActivity::class.java)
            intent.putExtra("commit_url", data.commit?.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return commitList.size
    }
}