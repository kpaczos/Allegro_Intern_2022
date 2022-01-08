package com.example.allegro_intern_2022.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.allegro_intern_2022.databinding.ItemRepoPreviewBinding
import com.example.allegro_intern_2022.models.RepoResponseItem
import com.example.allegro_intern_2022.ui.HomeFragmentDirections


class RepoAdapter:RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    inner class RepoViewHolder(val binding: ItemRepoPreviewBinding):RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<RepoResponseItem>() {
        override fun areItemsTheSame(
            oldItem: RepoResponseItem,
            newItem: RepoResponseItem
        ): Boolean {
            return oldItem.id ==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RepoResponseItem,
            newItem: RepoResponseItem
        ): Boolean {
            return oldItem ==newItem
        }
    }

    private val differ = AsyncListDiffer(this,diffCallback)
    var repository:List<RepoResponseItem>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(ItemRepoPreviewBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int){
        val currRepo = repository[position]

        holder.binding.apply {
            name.text = currRepo.name
            description.text = currRepo.description
            language.text = currRepo.language
        }

        holder.itemView.setOnClickListener { mView->
            val direction = HomeFragmentDirections
                .actionHomeFragmentToDetailFragment(currRepo)
            mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount() = repository.size


}