package com.example.practicejdbc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.practicejdbc.databinding.ActivityMain2Binding
import com.example.practicejdbc.databinding.ActivityMainBinding
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class MainActivity : AppCompatActivity() {
    lateinit var b: ActivityMainBinding
    lateinit var con :Connection

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btn.setOnClickListener {
            val username = b.username.text.toString()
            val password = b.password.text.toString()
            if (!username.isEmpty() && !password.isEmpty()){
                try {
                    // that's for creating instance of the Driver
                    Class.forName("com.mysql.jdbc.Driver").newInstance()
                    con = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9602375","username","password")
                    val stat = con.createStatement()
                    val login = "SELECT * FROM login"
                    val res = stat.executeQuery(login)
                    while (res.next()){
                        b.display.append( res.getString("username") + res.getString("password") )
//                        if (username == res.getString("username") && password == res.getString("password")){
//                            startActivity(Intent(applicationContext ,MainActivity2::class.java))
//                        }else{
//                            Toast.makeText(this,"its connected .",Toast.LENGTH_SHORT).show()
//                            Toast.makeText(this,"wrong user or password .please try anouther",Toast.LENGTH_SHORT).show()
//                        }
                    }
                    con.close()
    //        val queryInsert = "INSERT INTO team_one (id,first_name,last_name,jobtitle,establishment) VALUES (null, 'ussama', 'atmani', 'mantenance','devloper');"
    //        val queryDelete = "DELETE FROM team_one WHERE id=2"
    //        stat.executeUpdate(queryInsert)
    //        stat.executeUpdate(queryDelete)
                }catch (e:Exception){
                    Log.i("error is" , e.message.toString())
                }
            }else {
                Toast.makeText(this , "dont let the username & the password empty .",Toast.LENGTH_SHORT).show()
            }
        }

    }
}