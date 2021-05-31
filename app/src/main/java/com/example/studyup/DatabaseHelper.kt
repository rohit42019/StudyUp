package com.example.studyup

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper :  SQLiteOpenHelper
{
    companion object{
        const val DB_NAME = "StudyUp.db"
    }
    private var dbContext : Context?
    constructor(dbContext: Context?) : super(dbContext,DB_NAME,null,1)
    {
        this.dbContext = dbContext
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Users(Username Text primary key,Password Text not null,Email Text not null,Mobile_Number Text not null)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE if exists Users")
    }
    public fun insertData(username : String, password : String, email : String, mobile_number : String) : Boolean
    {
        val db = writableDatabase
        val content = ContentValues()
        content.put("Username" , username)
        content.put("Password" , password)
        content.put("Email" , email)
        content.put("Mobile_Number" , mobile_number)
        val result = db.insert("Users",null,content).toInt()
        if(result == -1)
        {
            return false
        }
        return true
    }
    public fun checkCredentialsForRegistration(username :String) : Boolean
    {
        val userName = username.trim()
        val db = writableDatabase
        val cursor = db.rawQuery("SELECT * FROM Users WHERE Username = ?",arrayOf<String>(userName))
        if(cursor.count>0)
        {
            cursor.close()
            return true
        }
        cursor.close()
        return false
    }
    public fun checkCredentialsForLogin(username: String,password: String) : Boolean
    {
        val db = writableDatabase
        val cursor = db.rawQuery("SELECT * FROM Users WHERE Username = ? and Password = ?",arrayOf<String>(username,password))
        if(cursor.count>0)
        {
            cursor.close()
            return true
        }
        cursor.close()
        return false
    }
}