package com.example.firstassignment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText



import androidx.appcompat.app.AppCompatActivity

class TaskEntry:AppCompatActivity() {
    private lateinit var _edittext: EditText
    private lateinit var _calender:DatePicker
    private lateinit var _save_button:Button
    private lateinit var _discard_button:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        _discard_button=findViewById<Button>(R.id.discard_button)
        _discard_button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                finish()
            }

        })
    }

}