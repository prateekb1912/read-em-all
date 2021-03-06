package com.criclytica.reademall.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(
        context,
        "booklists.db",
        null,
        1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(BookListsTable.CMD_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}