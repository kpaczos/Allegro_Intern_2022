package com.example.allegro_intern_2022.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.allegro_intern_2022.R
import com.example.allegro_intern_2022.adapters.RepoAdapter
import com.example.allegro_intern_2022.databinding.FragmentListRepositoriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment:Fragment(R.layout.fragment_list_repositories) {
    private var _binding: FragmentListRepositoriesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RepoViewModel by viewModels()
    private lateinit var repoAdapter: RepoAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentListRepositoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRv()

    }

    private fun setUpRv(){

        repoAdapter = RepoAdapter()

        binding.repoList.apply {
            layoutManager = GridLayoutManager(requireContext(),1)
            setHasFixedSize(true)
            adapter = repoAdapter
        }

        viewModel.repoResponse.observe(requireActivity(),{response->
            repoAdapter.repository = response
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}