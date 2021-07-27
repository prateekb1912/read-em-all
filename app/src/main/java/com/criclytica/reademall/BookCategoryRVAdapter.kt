package com.criclytica.reademall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class BookCategoryRVAdapter(private val bookCategories: ArrayList<String>) : RecyclerView.Adapter<BookCategoryRVAdapter.CategorySelectViewHolder>() {

    class CategorySelectViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val listPosition = itemView.findViewById(R.id.tvItemNum) as TextView
        val listTitle = itemView.findViewById(R.id.tvCategoryTitle) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorySelectViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.category_select_view_holder,
                parent,
                false)

        return CategorySelectViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategorySelectViewHolder, position: Int) {
        holder.listPosition.text = "${position + 1}."
        holder.listTitle.text = bookCategories[position]
    }

    override fun getItemCount(): Int = bookCategories.size

}
