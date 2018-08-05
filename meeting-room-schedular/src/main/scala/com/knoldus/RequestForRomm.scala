
package com.knoldus
import java.util.Calendar

import scala.io.StdIn.{readInt, readLine}
import org.slf4j.LoggerFactory

class RequestForRoom(val roomStatus:RoomAllocation) {
  val logger = LoggerFactory.getLogger(classOf[RequestForRoom])

  def requestForRoom()={

    logger.info("Enter the room id you want to book")
    val requestRoomId= readInt()
    logger.info("Do you want the meeting room or conference room")
    logger.info("Choose 1 for meeting room and 2 for conference room")
    val roomType = readInt()
    logger.info("Enter the emp id you want to book")
    val empId=readInt()
    logger.info("Enter the no of employees you want to book")
    val size= readInt()
    logger.info("Enter the time you want to book")
    val time= readLine()
    logger.info("Enter the time duration you want to book")
    val duration= readLine()

    roomType match{
      case 1 =>
        if(size==1 && duration.toInt>30)
          logger.info("Individual can get room for maximum 30 minutes")
        else if(size>1 && duration.toInt>120)
          logger.info("Team can get room for maximum 120 minutes")
        else
          roomStatus.meetingRoomStatus(empId,requestRoomId,duration,time,size )
      case 2 =>roomStatus.conferenceRoomStatus(requestRoomId)
    }

  }

}
