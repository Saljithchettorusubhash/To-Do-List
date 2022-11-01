package com.example.firstassignment
import android.content.ContentValues
import android.database.Cursor

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var _db: SQLdatabase
    private lateinit var _sdb: SQLiteDatabase
    private lateinit var _textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _textview=findViewById<TextView>(R.id.textview)

        _db= SQLdatabase(this,"test.db",null,1)
        _sdb=_db.writableDatabase

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



    }


