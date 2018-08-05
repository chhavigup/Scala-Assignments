
package com.knoldus
import db.Database
import org.slf4j.LoggerFactory
class RoomDetails(val database: Database,val req:RequestForRoom){

  val logger = LoggerFactory.getLogger(classOf[RoomDetails])
  val connection = database.createConnection()
  val statement = connection.createStatement

  def showRoomDetails()={

    val resultSet = statement.executeQuery("Select * from ROOMDETAILS")
    while(resultSet.next)
      {
        val roomId = resultSet.getInt("roomId")
        val roomName = resultSet.getString("roomName")
        val roomType = resultSet.getString("roomType")
         logger.info(s" \n Room Id = $roomId \n Room Name = $roomName \n Room Type = $roomType")
      }
    req.requestForRoom()
  }
}
