package com.example.practicalenoch.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.practicalenoch.DetailScreenActivity
import com.example.practicalenoch.R
import com.example.practicalenoch.model.RepoResponseItem

class RepositoryAdapter(
    private val trendingRepoList: ArrayList<RepoResponseItem?>?,
    val context: Context
) :
    RecyclerView.Adapter<RepositoryAdapter.TrendingRepoViewHolder>() {

    class TrendingRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var dec: TextView = itemView.findViewById(R.id.tv_dec)
        var share: LinearLayout = itemView.findViewById(R.id.ll_share)
        var mainLayout: LinearLayout = itemView.findViewById(R.id.ll_main)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourite_repo_data_layout, parent, false)
        return TrendingRepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingRepoViewHolder, position: Int) {
        val data: RepoResponseItem? = trendingRepoList!![position]
        holder.name.text = data!!.name
        holder.dec.text = data.description
        holder.share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Name: ${data.name} \nDescription: ${data.description} \nURL: ${data.htmlUrl}"
                )
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            context.startActivity(shareIntent)
        }
        holder.mainLayout.setOnClickListener {
            val intent = Intent(context, DetailScreenActivity::class.java)
            intent.putExtra("name", data.name)
            intent.putExtra("description", data.description)
            intent.putExtra("branch_url", data.branchesUrl)
            intent.putExtra("issue_url", data.issuesUrl)
            intent.putExtra("issue_count", data.openIssuesCount.toString())
            intent.putExtra("url", data.htmlUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return trendingRepoList!!.size
    }
}