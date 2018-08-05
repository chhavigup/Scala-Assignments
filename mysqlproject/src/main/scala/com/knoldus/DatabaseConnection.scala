package com.knoldus
package db
import java.sql.{Connection,DriverManager}

class DatabaseConnection {

  def getConnection: Connection = {
    val url = "jdbc:mysql://localhost:3306/MeetingRoom"
    val driver = "com.mysql.jdbc.Driver"
    val username = "root"
    val password = "root"
    val connection:Connection = {
      Class.forName(driver)
      DriverManager.getConnection(url, username, password)
    }
    connection
  }
}
