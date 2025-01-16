package com.example.andkotlinproject

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Write(var team: String="", var name: String="", var text: String=""):java.io.Serializable //객체 타입으로 전달

class MyDBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    companion object { //static 멤버 변수 선언
        val DATABASE_NAME = "write.db"
        val DATABASE_VER = 1
        val TABLE_NAME = "write"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //_id : 0, team : 1, name : 2, text : 3
        var sql = "create table $TABLE_NAME(_id INTEGER PRIMARY KEY autoincrement, team text, name text, text text)"
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists $TABLE_NAME")
        onCreate(db)
    }

    //@SuppressLint: 경고를 무시하는 명령어, "Range": getColumnIndex()와 관련된 경고
    @SuppressLint("Range")
    fun allTodo(): MutableList<Write> {
        var data = mutableListOf<Write>()
        val sql = "select * from ${TABLE_NAME}"
        val db = readableDatabase
        val cursor = db.rawQuery(sql, null)
        if (cursor.count > 0) {
            while (cursor.moveToNext()) {
                val write = Write()
                write.team = cursor.getString(1)
                write.name = cursor.getString(2)
                write.text = cursor.getString(3)
                data.add(write)
            }
        }
        cursor.close()
        db.close()
        return data
    }

    fun addTodo(write: Write) {
        val sql = "insert into ${TABLE_NAME}(team, name, text) values(?,?,?);"
        val db = writableDatabase;
        val args = arrayOf(write.team, write.name, write.text)
        db.execSQL(sql, args)
        db.close()
    }
}