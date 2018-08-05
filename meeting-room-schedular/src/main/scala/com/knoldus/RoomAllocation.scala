
package com.knoldus
import java.sql.{Connection, ResultSet, Statement}

import db.{Database, InsertData}
import org.slf4j.{Logger, LoggerFactory}
class RoomAllocation(val db:Database,val insert:InsertData) {

  val logger: Logger = LoggerFactory.getLogger(classOf[RoomAllocation])
  val connection: Connection = db.createConnection()
  val statement: Statement = connection.createStatement

  def meetingRoomStatus(reqEmpId: Int, reqRoomId: Int, reqDuration: String, reqTime: String, reqSize: Int): AnyVal = {
    val result = statement.executeQuery(s"select * from MEETINGROOM where roomId ='$reqRoomId' or empId = '$reqEmpId' ")
    while (result.next) {
      println("in while")
      val roomId = result.getInt("roomId")
      val empId = result.getInt("empId")
      println(roomId)
      println(empId)
      println(reqEmpId)
      println(reqRoomId)
      val time = result.getString("getTime")
      val duration = result.getString("timeDuration")
      val size = result.getInt("empSize")
      //println("in   if(roomId)
      if (empId == reqEmpId && !(roomId == reqRoomId))
        logger.info("Already applied for today.. try again tomorrow")
      else if (!(empId == reqEmpId )&& roomId == reqRoomId) {
        if (time == reqTime)
          logger.info("Not available for the requested time .. Try for some other time")
        else {

        }
      }



    }
  }


  def conferenceRoomStatus(roomId: Int): Unit = {

  }
}


