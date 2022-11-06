package com.example.firstassignment

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

public class Database (context: Context,tasklist:String,factory: SQLiteDatabase.CursorFactory?,version: Int)
    :SQLiteOpenHelper(context,tasklist,factory,version) {
    private val CREATE_TABLE_TASK: String = "create table Task(" +
            "ID integer primary key autoincrement," +
            "TASK string" +
            ")";
    private val CREATE_TABLE_TASK_THINGS: String = "create table todoitems(" +
            "ID integer primary key autoincrement," +
            "TASK_ID integer," +
            "TASK_THINGS string," +
            "DEADLINE_DATE string" +
            ")";


    private val DROP_TABLE_TASK: String = "drop table Task"
    private val DROP_TABLE_TASK_THINGS: String = "drop table todoitems"


    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_TABLE_TASK);
        p0?.execSQL(CREATE_TABLE_TASK_THINGS)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(DROP_TABLE_TASK)
        p0?.execSQL(CREATE_TABLE_TASK)
        p0?.execSQL(DROP_TABLE_TASK_THINGS)
        p0?.execSQL(CREATE_TABLE_TASK_THINGS)
    }


    public fun fetch(): ArrayList<Model1> {
        val taskthings = ArrayList<Model1>()
        val td = writableDatabase
        val selectQuery = "SELECT * FROM TASK"
        val cursor = td.rawQuery(selectQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val todo = Model1()
                    todo.taskid =
                        Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("ID")))
                    todo.taskthing = cursor.getString(cursor.getColumnIndexOrThrow("TASK"))
                    taskthings.add(todo)
                } while (cursor.moveToNext())
            }

        }
        cursor.close()
        return taskthings
    }

}