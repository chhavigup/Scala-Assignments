package com.knoldus

import com.knoldus.db.DatabaseConnection

class Mroom1(Entry_time: String, Exit_time: String, Team: Boolean, Date: String, Group_Id: Int) {

  def checkAvailability(): String = {

    if (Team) {
      val connection = new DatabaseConnection().getConnection
      val statement = connection.createStatement

      val query1 = s"SELECT * from mroom1 where Date='$Date' order By Entry_time Asc "
      val rx = statement.executeQuery(query1)

      var EntryFinal = ""

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
            EntryFinal = Entry_time

            bool = false
          }

        }
        else if (entime >= new IncrementTime2Hr().increment(ptime) && Exit_time <= entime) {

          if (Entry_time >= ptime) {

            time = new IncrementTime2Hr().increment(Entry_time)
            EntryFinal = Entry_time
          }
          else {
            EntryFinal = ptime
          }
          bool = false
        }
        ptime = time
      }

      if (bool) {
        //println(query2)

        if (ptime > "18:30") {
          EntryFinal = "20:30"
        }
        else {

          if (Entry_time >= ptime) {

            time = new IncrementTime2Hr().increment(Entry_time)
            EntryFinal = Entry_time
          }
          else {
            EntryFinal = time
          }
        }
      }

      EntryFinal
    }
    else {
      val connection = new DatabaseConnection().getConnection
      val statement = connection.createStatement

      val query1 = s"SELECT * from mroom1 where Date='$Date' order By Entry_time Asc "
      val rx = statement.executeQuery(query1)

      var EntryFinal = ""

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
            EntryFinal = Entry_time
            bool = false
          }

        }
        else if (entime >= new IncrementTimehalfHr().increment(ptime) && Exit_time <= entime) {

          if (Entry_time >= ptime) {

            time = new IncrementTimehalfHr().increment(Entry_time)
            EntryFinal = Entry_time
          }
          else {
            EntryFinal = ptime
          }
          bool = false
        }
        ptime = time
      }

      if (bool) {

        if (ptime > "18:30") {
          EntryFinal = "20:30"
        }
        else {

          if (Entry_time >= ptime) {

            time = new IncrementTimehalfHr().increment(Entry_time)
            EntryFinal = Entry_time
          }
          else {
            EntryFinal = time
          }
        }
      }
      //  println("hgfj"+EntryFinal)
      EntryFinal
    }
  }
}
