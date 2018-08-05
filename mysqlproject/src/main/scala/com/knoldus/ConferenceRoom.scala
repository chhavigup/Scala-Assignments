package com.knoldus

import com.knoldus.db.DatabaseConnection

class ConferenceRoom (Group_Id:Int,Entry_time:String,Exit_time:String,Lead_Name:String,Date:String) {

  def checkAvailablity(): Boolean = {
    val connection = new DatabaseConnection().getConnection
    val statement = connection.createStatement
    println(Exit_time)
    val rs = statement.executeQuery(s"SELECT * from conferenceroom where Date='$Date' and Group_Id='$Group_Id' ")
    if (rs.next==true) {
      false
    }
    else {

      val query1 = s"SELECT * from conferenceroom where Date='$Date' order By Entry_time Asc "
      val rx = statement.executeQuery(query1)
      //var ent=0
      var ptime = ""
      var count = 0
      var bool = true
      var time = ""
      while (rx.next && bool) {
        count += 1
        val entime = rx.getString("Entry_time")
        time = rx.getString("Exit_time")

        if (count == 1) {
          if (Exit_time <= entime) {
            val st = connection.createStatement
            val query2 = s"INSERT INTO conferenceroom  VALUES ($Group_Id, '$Date', '$Entry_time', '$Exit_time', '$Lead_Name')"
            val rr = st.executeUpdate(query2)
            if (rr > 0) {
              println(s"1.Your Slot is Booked from $Entry_time to $Exit_time")

            }
            bool = false
          }

        }
        else if (entime >= new IncrementTime2Hr().increment(ptime) && Exit_time <= entime) {
          // insert
          val y = new IncrementTime2Hr().increment(ptime)
          println(y)
          println(entime)
          //connection.close()
          val st = connection.createStatement
          // val query2=s"INSERT INTO conferenceroom  VALUES ($Group_Id, '$Date', '$time', '$x', '$Lead_Name')"
          //println(query2)

          if (Entry_time >= ptime) {

            time = new IncrementTime2Hr().increment(Entry_time)
            val query2 = s"INSERT INTO conferenceroom  VALUES ($Group_Id, '$Date', '$Entry_time', '$time', '$Lead_Name')"
            val ss = st.executeUpdate(query2)
            if (ss > 0) {
              println(s"1.Your Slot is Booked from $Entry_time to $time")
            }
          }
          else {
            println(s"1. Sorry we can not have time slot at your required time but we can allot a slot from $ptime to $y")
            println(" Press \n 1.Confirm \n 2.Cancel")
            val query2 = s"INSERT INTO conferenceroom  VALUES ($Group_Id, '$Date', '$ptime', '$y', '$Lead_Name')"
            val rd = scala.io.StdIn.readInt()
            if (rd == 1) {
              val ss = st.executeUpdate(query2)
              if (ss > 0) {
                println(s"2.Your Slot is Booked from $ptime to $y")
              }
            }
          }
          // connection.close()
          bool = false
        }
        ptime = time
      }

        if (bool) {
          //println(query2)

          if(ptime > "18:30") {
           println("sorry time slot not available today")

          }
          else {
            val z = new IncrementTime2Hr().increment(ptime)
            if (Entry_time >= ptime) {

              time = new IncrementTime2Hr().increment(Entry_time)
              val query2 = s"INSERT INTO conferenceroom  VALUES ($Group_Id, '$Date', '$Entry_time', '$time', '$Lead_Name')"
              val ss = statement.executeUpdate(query2)
              if (ss > 0) {
                println(s"last Your Slot is Booked from $Entry_time to $time")
              }
            }
            else {
              val query2 = s"INSERT INTO conferenceroom  VALUES ($Group_Id, '$Date', '$time', '$z', '$Lead_Name')"
              println(s"1. Last Sorry we can not have time slot at your required time but we can allot a slot from $time to $z ")
              println(" Press \n 1.Confirm \n 2.Cancel")
              val rd = scala.io.StdIn.readInt()
              if (rd == 1) {
                val ss = statement.executeUpdate(query2)
                if (ss > 0) {
                  println(s"Your Slot is Booked from $time to $z")
                }
              }

            }
          }
        }

      //  statement.executeUpdate(s"INSERT INTO conference room  VALUES (, 'Simpson', 'Mr.', 'Springfield', 2001)")
      true
    }

  }
}
