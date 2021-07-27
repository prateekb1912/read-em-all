package com.criclytica.reademall

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

val bookCategories = arrayOf("2022 Reading List", "Non-Fiction", "Fiction", "Self-Help")

class BookCategoryRVAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = bookCategories.size

}
