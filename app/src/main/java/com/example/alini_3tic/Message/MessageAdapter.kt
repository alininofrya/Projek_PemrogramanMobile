package com.example.alini_3tic.Message

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.alini_3tic.R
import com.example.alini_3tic.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = messages[position]
// Muat gambar dari URL ke ImageView
        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
        return view
    }
}
