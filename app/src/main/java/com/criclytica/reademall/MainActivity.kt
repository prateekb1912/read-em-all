package com.criclytica.reademall

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.InputType
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.criclytica.reademall.db.BookListsTable
import com.criclytica.reademall.db.DBHelper
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val bookLists = ArrayList<CategoryList>()
    lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BookCategoryRVAdapter(bookLists)

        db = DBHelper(this).writableDatabase

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            showCreateCategoryDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showCreateCategoryDialog() {
        val dialogTitle = getString(R.string.name_of_categ)
        val positiveButtonTitle = getString(R.string.create)

        val builder = AlertDialog.Builder(this)
        val etNewCategory = EditText(this)

        etNewCategory.inputType = InputType.TYPE_CLASS_TEXT

        builder.setTitle(dialogTitle)
                .setView(etNewCategory)
                .setPositiveButton(positiveButtonTitle) { dialog, _ ->
                    val newList = CategoryList(etNewCategory.text.toString(), false)

                    BookListsTable.insertList(db, newList)
                    bookLists.add(newList)

                    dialog.dismiss()
                }
                .create()
                .show()

        refreshCategoryList()
    }

    fun refreshCategoryList() {
        val bookList = BookListsTable.getAllLists(db)
        Log.d("BOOKS", bookList.toString())
    }
}