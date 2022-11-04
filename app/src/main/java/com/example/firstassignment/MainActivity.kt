package com.example.firstassignment
import android.content.ContentValues
import android.database.Cursor

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText

import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var _db: SQLdatabase
    private lateinit var _sdb: SQLiteDatabase
    private lateinit var _textview: TextView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _textview=findViewById<TextView>(R.id.textview)

//recyclermain view
        _edittext = findViewById<EditText>(R.id.edit_activity)
        _recyclerview = findViewById<RecyclerView>(R.id.recyclerviewmain)
        _recyclerview.layoutManager = LinearLayoutManager(this)
        var recycler_adapter_main: RecyclerAdapterMain = RecyclerAdapterMain(this, _ri_arraylist)
        _recyclerview.adapter = recycler_adapter_main




        _db= SQLdatabase(this,"test.db",null,1)
        _sdb=_db.writableDatabase



//recyclerfunction
        _edittext.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                // if the enter button has been clicked then add a new item to the arraylist and update
                if(p1 == EditorInfo.IME_ACTION_DONE) {
                    // create an item and add it to the array list and tell the recycler adapter to
                    // update the display
                    _ri_arraylist.add(RecyclerItemmain(_edittext.text.toString(), _count++))
                    recycler_adapter_main.notifyDataSetChanged()
                    // return true to indicate this event has been handled
                    return true
                }
                // if we get to this point then the event has not been handled so we can return false
                return false;
            }
        })















//task button
        _textview.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                startTask()
            }
        })





        addData()

    }



    private fun addData() {
        val row1: ContentValues = ContentValues().apply {
            put("TASK", "Add ")

        }
        _sdb.insert("test", null, row1)
        val row2: ContentValues = ContentValues().apply {
            put("TASK", "jane")

        }
        _sdb.insert("test", null, row2)
        val row3: ContentValues = ContentValues().apply {
            put("TASK", "jim")

        }
        _sdb.insert("test", null, row3)
    }

    private fun startTask(){
        var intent: Intent = Intent(this, TaskEntry::class.java)
        startActivity(intent)
    }

    //recyclerview variables
    private lateinit var _edittext: EditText
    private lateinit var _recyclerview: RecyclerView
    private var _ri_arraylist : ArrayList<RecyclerItemmain> = ArrayList<RecyclerItemmain>()
    private var _count: Int = 0





    }


