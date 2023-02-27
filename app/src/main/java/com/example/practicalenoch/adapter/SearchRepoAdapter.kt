package com.example.practicalenoch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicalenoch.R
import com.example.practicalenoch.model.RepoResponseItem
import com.example.practicalenoch.utils.SharedPreference
import kotlin.collections.ArrayList

class SearchRepoAdapter(
    private val trendingRepoList: List<RepoResponseItem>,
    val context: Context
) :
    RecyclerView.Adapter<SearchRepoAdapter.TrendingRepoViewHolder>() {
    var itemSelected = -1

    class TrendingRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var dec: TextView = itemView.findViewById(R.id.tv_dec)
        var selected_icon: LinearLayout = itemView.findViewById(R.id.ll_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingRepoViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_repo_data_layout, parent, false)
        return TrendingRepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrendingRepoViewHolder, position: Int) {
        val data: RepoResponseItem = trendingRepoList[position]
        holder.name.text = data!!.name
        holder.dec.text = data.description
        if (itemSelected == position) {
            holder.selected_icon.visibility = View.VISIBLE
        } else {
            holder.selected_icon.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            setSingleSelection(position, holder)
        }
    }

    fun addButtonClick() {
        var items: ArrayList<RepoResponseItem?>? = SharedPreference(context).getArrayList("List")
        if (items != null) {
            items.add(trendingRepoList[itemSelected])
        } else {
            items = ArrayList()
            items.add(trendingRepoList[itemSelected])
        }
        SharedPreference(context).saveArrayList(items, "List")
    }

    private fun setSingleSelection(position: Int, holder: TrendingRepoViewHolder) {
        if (position == RecyclerView.NO_POSITION) return
        notifyItemChanged(itemSelected)
        itemSelected = position
        holder.selected_icon.visibility = View.VISIBLE
    }

    override fun getItemCount(): Int {
        return trendingRepoList.size
    }
}