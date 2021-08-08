package com.criclytica.reademall.db

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.criclytica.reademall.CategoryList

object BookListsTable {
    val TABLE_NAME = "bookLists"

    object Columns {
        val ID = "id"
        val LIST = "list"
        val READ = "read"
    }

    val CMD_CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS $TABLE_NAME
        (
        ${Columns.ID} PRIMARY KEY INT AUTOINCREMENT,
        ${Columns.LIST} TEXT ,
        ${Columns.READ} BOOLEAN,
        );
    """.trimIndent()

    fun insertList(db: SQLiteDatabase, list: CategoryList) {
        val row = ContentValues()
        row.put(Columns.LIST, list.name)
        row.put(Columns.READ, list.read)

        db.insert(TABLE_NAME, null, row)
    }

    fun getAllLists(db: SQLiteDatabase): ArrayList<CategoryList> {
        val lists = ArrayList<CategoryList>()

        var cursor = db.query(
                TABLE_NAME,
                arrayOf(Columns.ID, Columns.LIST, Columns.READ),
                null,
                null,
                null,
                null,
                null
        )

        while (cursor.moveToNext()) {
            val list = CategoryList(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2).toBoolean()
            )

            lists.add(list)
        }

        return lists
    }

}