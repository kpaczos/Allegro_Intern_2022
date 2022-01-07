package com.example.allegro_intern_2022.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.allegro_intern_2022.R
import com.example.allegro_intern_2022.models.RepoResponseItem
import kotlinx.android.synthetic.main.item_repo_preview.view.*

class RepoAdapter(val repos:List<RepoResponseItem>,val listener:OnAdapterListener):RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    inner class RepoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_repo_preview,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repository = repos[position]
        holder.itemView.apply {
          name.text = repository.name
            description.text = repository.description
            setOnClickListener { listener.onCLick(repository) }
        }
    }

    override fun getItemCount(): Int {
       return repos.size
    }

    interface OnAdapterListener{
        fun onCLick(result:RepoResponseItem)
    }
}