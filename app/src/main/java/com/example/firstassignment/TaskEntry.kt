package com.example.firstassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText



import androidx.recyclerview.widget.RecyclerView

class TaskEntry:AppCompatActivity() {
    private lateinit var _calender:DatePicker
    private lateinit var _save_button:Button
    private lateinit var _discard_button:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        _discard_button=findViewById<Button>(R.id.discard_button)

        //step10
        _edittext = findViewById<EditText>(R.id.edittext)
        _recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        _recyclerview.layoutManager = LinearLayoutManager(this)
        var recycler_adapter: RecyclerAdapter = RecyclerAdapter(this, _rl_arraylist)
        _recyclerview.adapter = recycler_adapter


        _edittext.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                // if the enter button has been clicked then add a new item to the arraylist and update
                if(p1 == EditorInfo.IME_ACTION_DONE) {
                    // create an item and add it to the array list and tell the recycler adapter to
                    // update the display
                    _rl_arraylist.add(RecyclerItem(_edittext.text.toString(), _count++))
                    recycler_adapter.notifyDataSetChanged()
                    // return true to indicate this event has been handled
                    return true
                }
                // if we get to this point then the event has not been handled so we can return false
                return false;
            }
        })





        _discard_button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                finish()
            }

        })


    }

    private lateinit var _edittext: EditText
    private lateinit var _recyclerview: RecyclerView
    private var _rl_arraylist : ArrayList<RecyclerItem> = ArrayList<RecyclerItem>()
    private var _count: Int = 0



}