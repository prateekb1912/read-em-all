package com.criclytica.reademall

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log

class CategoryListDataManager(private val context: Context) {
    fun saveList(list: CategoryList) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putStringSet(list.name, list.tasks.toHashSet())
                .apply()
    }

    fun readLists(): ArrayList<CategoryList> {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val contents = sharedPreferences.all

        val categoryLists = ArrayList<CategoryList>()

        for (catList in contents) {
            val itemsHashSet = ArrayList(catList.value as HashSet<String>)
            val list = CategoryList(catList.key, itemsHashSet)

            categoryLists.add(list)
        }

        return categoryLists
    }

    fun removeCategory(lists: ArrayList<CategoryList>, position: Int) {
        val del = lists[position]

        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .remove(del.name)
                .apply()
        Log.d("SIZE", lists.size.toString())
    }
}