package com.example.practicejdbc

import android.annotation.SuppressLint
import android.os.StrictMode
import java.sql.Connection
import java.sql.DriverManager

class ConnectToSql {

    companion object{
        fun conClass():Connection{
//            Class.forName("com.mysql.jdbc.Driver");
            val con:Connection = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com/sql9602375","sql9602375","pUq7LMX2IT")

            return con
        }
    }

    /*
    import java.sql.*;
class MysqlCon{
public static void main(String args[]){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","root","root");
//here sonoo is database name, root is username and password
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from emp");
while(rs.next())
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
con.close();
}catch(Exception e){ System.out.println(e);}
}
}
    */
}