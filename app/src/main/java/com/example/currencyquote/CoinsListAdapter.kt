package com.example.currencyquote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class CoinsListAdapter(context: Context, private val coins: List<Coins>) :
    ArrayAdapter<Coins>(context, 0, coins) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    private fun createItemView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view =
            convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner, parent, false)

        val item = getItem(position)
        val itemImage = view.findViewById<ImageView>(R.id.item_image)
        val itemName = view.findViewById<TextView>(R.id.item_name)

        item?.let {
            itemImage.setImageResource(it.icon)
            itemName.text = it.name
        }
        return view
    }
}

