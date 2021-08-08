package com.criclytica.reademall.db

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



}