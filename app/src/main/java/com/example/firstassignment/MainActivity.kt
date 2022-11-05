package com.example.firstassignment
import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.database.Cursor

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText

import android.widget.TextView
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity(),ClickListener {

    private lateinit var _db: SQLdatabase
    private lateinit var _sdb: SQLiteDatabase
    private lateinit var _textview: TextView
    private lateinit var _add_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _add_button=findViewById<Button>(R.id.add_button)
        var helper=SQLdatabase(applicationContext)
        var db=helper.readableDatabase
        var rc=db.rawQuery("SELECT * FROM TASK ",null)




        //database
        if (rc.moveToNext())
            Toast.makeText(applicationContext,rc.getString(1),Toast.LENGTH_LONG).show()


//recyclermain view
        _edittext = findViewById<EditText>(R.id.edit_activity)
        _recyclerview = findViewById<RecyclerView>(R.id.recyclerviewmain)
        _recyclerview.layoutManager = LinearLayoutManager(this)
//        var recycler_adapter_main: RecyclerAdapterMain = RecyclerAdapterMain(this, _ri_arraylist)
      //  _recyclerview.adapter = recycler_adapter_main

//        getTaskData()



//recyclerfunction
//        _edittext.setOnEditorActionListener(object : TextView.OnEditorActionListener {
//            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
//                // if the enter button has been clicked then add a new item to the arraylist and update
//                if(p1 == EditorInfo.IME_ACTION_DONE) {
//                    // create an item and add it to the array list and tell the recycler adapter to
//                    // update the display
//                    _ri_arraylist.add(RecyclerItemmain("Akhil", _count++))
//                    recycler_adapter_main.notifyDataSetChanged()
//                    // return true to indicate this event has been handled
//                    return true
//                }
//                // if we get to this point then the event has not been handled so we can return false
//                return false;
//            }
//        })
//









//task button
        _add_button.setOnClickListener {
            var cl=ContentValues()
            cl.put("TASKNAME",_edittext.text.toString())
            db.insert("TASK",null,cl)

            var al=AlertDialog.Builder(this)
            al.setTitle("Add Task")
            al.setMessage("Task added Successfully")
            al.setPositiveButton("ok",DialogInterface.OnClickListener { dialogInterface, i ->
                _edittext.setText("")

            })
            al.show()
            getTaskData()
        }


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

    constructor(parcel: Parcel) : this() {
        _count = parcel.readInt()
    }


    //new recycler
    private fun getTaskData(){
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerviewmain)
        recyclerview.layoutManager = LinearLayoutManager(this)
//        val data = ArrayList<RecyclerItemmain>()
//
        var dbData = SQLdatabase(applicationContext)
        var db = dbData.readableDatabase
        var data = arrayListOf<RecyclerItemmain>()
        var str = "select * from TASK "

        var TaskData = db.rawQuery(str, null)
        TaskData.moveToFirst()
        //

        for (i in 0 until TaskData.count) {
            data.add(RecyclerItemmain(TaskData.getString(1) , TaskData.getInt(0)))
        }


        val adapter = MainLayoutAdapter(data,this)


        recyclerview.adapter = adapter

    }




    override fun onCellClickListener(data:RecyclerItemmain) {
        Toast.makeText(this,"Cell clicked"+data.tasknumber+"", Toast.LENGTH_SHORT).show()
    }


}
