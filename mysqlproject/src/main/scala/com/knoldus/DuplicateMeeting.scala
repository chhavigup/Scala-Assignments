package com.knoldus

import com.knoldus.db.DatabaseConnection

class DuplicateMeeting (Date:String,Group_Id:Int,Room:String) {

  def checkAvailabilty():Boolean={
    val connection = new DatabaseConnection().getConnection
    val statement = connection.createStatement

    val rs = statement.executeQuery(s"SELECT * from $Room where Date='$Date' and Employee_Id='$Group_Id' ")
    if (rs.next == true) {
      false
    }
    else
      true
  }
}
