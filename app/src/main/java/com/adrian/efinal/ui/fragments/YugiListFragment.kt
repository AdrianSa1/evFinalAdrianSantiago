package com.adrian.efinal.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.adrian.efinal.R

import com.adrian.efinal.databinding.FragmentYugiListBinding
import com.adrian.efinal.ui.viewmodels.CardListViewModel


class YugiListFragment : Fragment() {
    private lateinit var binding: FragmentYugiListBinding
    private lateinit var viewModel: CardListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CardListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentYugiListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVYugiListAdapter(listOf()){card->
            val destination = YugiListFragmentDirections.actionNoteListFragmentToCardDetailFragment(card)
            findNavController().navigate(destination)

        }
        binding.rvNoteList.adapter = adapter
        viewModel.notes.observe(requireActivity()) {
            adapter.cards = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getNotesFromService()
    }

}