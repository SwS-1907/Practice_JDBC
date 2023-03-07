package com.example.practicejdbc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicejdbc.databinding.ActivityMain2Binding
import com.example.practicejdbc.databinding.ActivityMainBinding
import java.lang.Exception
import java.sql.DriverManager

class MainActivity2 : AppCompatActivity() {

    lateinit var b: ActivityMain2Binding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(b.root)

        try {
            val con = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9602375","sql9602375","pUq7LMX2IT")
            val stat = con.createStatement()
            b.btn.setOnClickListener {
                val querySelect = "SELECT * FROM team_one"
                val res = stat.executeQuery(querySelect)
                while (res.next()){
                    b.txt1.text = "id:${res.getInt("id")} |firstname:${res.getString("first_name")} |lastname:${res.getString("last_name")} |jobTitle :${res.getString("jobtitle")} |establishment: ${res.getString("establishment")}"
                }
                con.close()
            }
//        val queryInsert = "INSERT INTO team_one (id,first_name,last_name,jobtitle,establishment) VALUES (null, 'ussama', 'atmani', 'mantenance','devloper');"
//        val queryDelete = "DELETE FROM team_one WHERE id=2"
//        stat.executeUpdate(queryInsert)
//        stat.executeUpdate(queryDelete)
        }catch (e : Exception){
            System.out.println(e.message.toString())
        }

    }
}