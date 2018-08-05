package com.knoldus

import com.knoldus.db.DatabaseConnection

class MeetingRoomInsert {

  def Insertion(table: String, Entry_time: String, Exit_time: String, Employee_Id: Int, Employee_Name: String, Date: String,Usertime:String) = {
    val connection = new DatabaseConnection().getConnection
    val statement = connection.createStatement

     if (Exit_time!="20:30") {
        if(Entry_time!=Usertime) {
          println(s"Sorry we can not have time slot at your required time but we can allot a slot from $Entry_time to $Exit_time ")
          println(" Press \n 1.Confirm \n 2.Cancel")
          val rd = scala.io.StdIn.readInt()
          val query2 = s"INSERT INTO $table  VALUES ($Employee_Id, '$Date', '$Entry_time', '$Exit_time', '$Employee_Name')"

          if (rd == 1) {
            val ss = statement.executeUpdate(query2)
            if (ss > 0) {
              println(s"Your Slot is Booked in $table from $Entry_time to $Exit_time")
            }
          }
        }
       else
          {
            val query2 = s"INSERT INTO $table  VALUES ($Employee_Id, '$Date', '$Entry_time', '$Exit_time', '$Employee_Name')"
            val ss = statement.executeUpdate(query2)
            if (ss > 0) {
              println(s"Your Slot is Booked in $table from $Entry_time to $Exit_time")
            }
          }
    }
    else
      {
        println("Sorry we can Not have free slot today ")
      }
  }
}
