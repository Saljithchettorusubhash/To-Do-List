package com.example.firstassignment
import android.content.ContentValues


import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText

import android.widget.TextView

import android.view.View
import android.widget.Button

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity :  AppCompatActivity() {
    private lateinit var _edittext: EditText

    private lateinit var _mydb:Database
    private lateinit var _sdb: SQLiteDatabase
    private lateinit var _add_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _add_button=findViewById<Button>(R.id.add_button)
        _view_button=findViewById<Button>(R.id.view_button)


           _mydb = Database(this,"test.db",null,1)
        _sdb = _mydb.writableDatabase




//recyclermain view
        _edittext = findViewById<EditText>(R.id.edit_activity)
        _recyclerview = findViewById<RecyclerView>(R.id.recyclerviewmain)
        _recyclerview.layoutManager = LinearLayoutManager(this)
        _recycleradaptermain = RecyclerAdapterMain(this,_ri_arraylist)
        _recyclerview.adapter = _recycleradaptermain



        _add_button.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                var enteredtask = Model1()
                enteredtask.taskthing = _edittext.text.toString()
                _ri_arraylist.add(enteredtask)
                _recycleradaptermain.notifyDataSetChanged()
                addtask(_edittext.text.toString())

            }
        })



   fetchtask()

    }

    private fun addtask(taskName: String) {


            val entry:ContentValues=ContentValues().apply {

                put("TASK",taskName);
            }
            _sdb.insert("TASK",null,entry)



    }


    fun  fetchtask(){
        _ri_arraylist=_mydb.fetch()!!
        _recycleradaptermain = RecyclerAdapterMain(this,_ri_arraylist)
        _recyclerview.adapter=_recycleradaptermain
        _recycleradaptermain.notifyDataSetChanged()


    }





    //recyclerview variables
    private lateinit var _recyclerview: RecyclerView
    private var _ri_arraylist : ArrayList<Model1> = ArrayList<Model1>()
    private var _count: Int = 0
   private lateinit var _recycleradaptermain:RecyclerAdapterMain
    private lateinit var _textview: TextView

    private lateinit var _view_button:Button

    }


