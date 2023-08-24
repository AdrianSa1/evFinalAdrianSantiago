package com.adrian.efinal.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.adrian.efinal.databinding.FragmentYugiFavoriteBinding


class YugiFavoriteFragment : Fragment() {

    private lateinit var binding: FragmentYugiFavoriteBinding
    private lateinit var viewModel: CardFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =ViewModelProvider(requireActivity())[CardFavoriteViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentYugiFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter= RVYugiListAdapter(listOf()){card ->
            val destination =YugiFavoriteFragmentDirections.actionNoteFavoriteFragmentToCardDetailFragment(card)
            findNavController().navigate(destination)
        }
        binding.rvFavorites.adapter= adapter
        viewModel.favorites.observe(requireActivity()){
            adapter.cards=it
            adapter.notifyDataSetChanged()
        }
        viewModel.getFavorites()
    }

}