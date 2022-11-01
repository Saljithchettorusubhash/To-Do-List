package com.example.firstassignment
import android.content.ContentValues
import android.database.Cursor

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.view.View


class MainActivity : AppCompatActivity() {

    private lateinit var _db: SQLdatabase
    private lateinit var _sdb: SQLiteDatabase
    private lateinit var _textview: TextView
    private lateinit var _add_item_button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _textview=findViewById<TextView>(R.id.textview)
        _add_item_button=findViewById<Button>(R.id.add_item_button)

        _db= SQLdatabase(this,"test.db",null,1)
        _sdb=_db.writableDatabase

//task button
        _add_item_button.setOnClickListener(object : View.OnClickListener{
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

    }


