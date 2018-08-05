package com.knoldus
package db
import java.sql.{Connection,DriverManager}

object database extends App{
  val url = "jdbc:mysql://localhost:3306/MeetingRoom"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = "root"
  var connection:Connection = _
  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url,username,password)
    val statement = connection.createStatement
    val rs = statement.executeQuery("SELECT * from mroom1")
    while (rs.next) {
      val host = rs.getInt("Employee_Id")
      val user = rs.getString("Entry_time")
      println("host = %s, user = %s".format(host,user))
    }
  } catch {
    case e: Exception => e.printStackTrace()
  }
  connection.close()
}