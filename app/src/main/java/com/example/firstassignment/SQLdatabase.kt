package com.example.firstassignment


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLdatabase (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?,
                       version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    private val CREATE_TABLE: String = "create table test(" +
            "ID integer primary key autoincrement," +
            "TASK string"+")"
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_TABLE)
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(CREATE_TABLE)
    }

}