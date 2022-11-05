package com.example.firstassignment


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLdatabase (context: Context)
    : SQLiteOpenHelper(context,"TASKDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE TASK(TASKID INTEGER PRIMARY KEY AUTOINCREMENT, TASKNAME TEXT) ")

        db?.execSQL("INSERT INTO TASK (TASKNAME) VALUES('')")
        db?.execSQL("INSERT INTO TASK (TASKNAME) VALUES('')")

    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }

}