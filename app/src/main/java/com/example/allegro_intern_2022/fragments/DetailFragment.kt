package com.example.allegro_intern_2022.fragments

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.allegro_intern_2022.R
import com.example.allegro_intern_2022.databinding.FragmentRepositoryBinding
import com.example.allegro_intern_2022.models.RepoResponseItem

class DetailFragment: Fragment(R.layout.fragment_repository) {

    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var repository : RepoResponseItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(
            inflater,container,false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repository = args.details

        populateUI()

    }

    private fun populateUI()
    {
        binding.apply {
            loginTv.text=repository.owner.login
            avatarImage.load(repository.owner.avatar_url){
                crossfade(true)
            }
            descriptiontv.text=repository.description
            val html_url = Html.fromHtml("<a href=\"${repository.clone_url}\"> URL </a>")
            urltv.text=html_url
            urltv.movementMethod = LinkMovementMethod.getInstance()
            languagetv.text=repository.language
            createdAtTv.text=repository.created_at
            updatedAtTv.text=repository.updated_at
            branchTv.text=repository.default_branch
            forksTv.text= repository.forks_count.toString()
            starsTv.text=repository.stargazers_count.toString()
            openIssuesTv.text=repository.open_issues.toString()
            watchersTv.text=repository.watchers_count.toString()


        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}