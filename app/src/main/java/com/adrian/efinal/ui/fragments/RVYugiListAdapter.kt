package com.adrian.efinal.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrian.efinal.databinding.ItemNoteBinding
import com.adrian.efinal.model.Card
import com.bumptech.glide.Glide

class RVYugiListAdapter (var cards: List<Card>,val onNoteClick:(Card)->Unit): RecyclerView.Adapter<NoteVH>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteVH(binding,onNoteClick)
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.bind(cards[position])
    }

}

class NoteVH(private val binding: ItemNoteBinding,val onNoteClick: (Card) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun bind(card: Card) {
        binding.txtNoteTitle.text = card.name
        binding.txtContentNote.text = card.type
        binding.txtLablesNote.text = card.attribute
        binding.txtCreateNote.text = card.race

        if (card.card_images.isNotEmpty()) {
            val imageUrl = card.card_images[0].image_url
            Glide.with(binding.root.context)
                .load(imageUrl)
                .into(binding.imageView)
        } else {
            // Aquí puedes mostrar una imagen o un indicador para indicar que no hay imágenes disponibles.
            // También puedes simplemente omitir la carga de la imagen si no hay imágenes.
        }

        binding.root.setOnClickListener{
            onNoteClick(card)
        }

    }

}