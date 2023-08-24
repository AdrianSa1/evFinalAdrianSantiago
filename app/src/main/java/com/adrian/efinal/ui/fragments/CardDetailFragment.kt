package com.adrian.efinal.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.adrian.efinal.R
import com.adrian.efinal.databinding.FragmentCardDetailBinding
import com.adrian.efinal.model.Card
import com.adrian.efinal.ui.viewmodels.CardListViewModel
import com.google.android.material.snackbar.Snackbar


class CardDetailFragment : Fragment() {

    private lateinit var binding: FragmentCardDetailBinding
    private val args: CardDetailFragmentArgs by navArgs()
    private lateinit var card:Card
    private lateinit var viewModel: CardDetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        card= args.card
        viewModel= ViewModelProvider(requireActivity())[CardDetailViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCardDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtTitle.text = card.name
        binding.txtLabels.text = card.attribute
        binding.txtNote.text = card.type
        if (card.isFavorite) {
            binding.btnAddFavorite.visibility = View.GONE
        }
        binding.btnAddFavorite.setOnClickListener {
            // agregar a favorito
            card.isFavorite = true
            viewModel.addFavorites(card)
            Snackbar.make(binding.root, "Agregado a favoritos", Snackbar.LENGTH_SHORT).show()
        }
    }




}