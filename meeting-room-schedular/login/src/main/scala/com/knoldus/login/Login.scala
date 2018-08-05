
package com.knoldus.login
import org.slf4j.LoggerFactory

import scala.io.StdIn.{readInt, readLine}
import db.{Database, InsertData}
import com.knoldus.{RequestForRoom, RoomAllocation, RoomDetails}
class Login(val db:Database,val room:RoomDetails) {
  val logger = LoggerFactory.getLogger(classOf[Login])

  def login()={
    val connection = db.createConnection()
    val statement = connection.createStatement
    logger.info("Enter the name of the user")
    val name = readLine()
    logger.info("Enter Employee Id")
    val employeeId = readInt()
    logger.info("Enter Employee number")
    val number = readLine()
   val result=statement.executeQuery(s"select * from EMPLOYEEDETAILS where empId ='$employeeId' and empName ='$name' and phoneNumber='$number'")
    //println("result.next="+result.next==true)
    if (result.next==true) room.showRoomDetails()
    else
      logger.info("Invalid Details")
  }

}

object t extends App{
  val d=new Database
  val i= new InsertData(d)
 // println("roomAlllction")
  val ra=new RoomAllocation(d,i)
 // println("request")
  val rr=new RequestForRoom(ra)
 // println("details")
  val r=new RoomDetails(d,rr)
  //println("login")
  val l=new Login(d,r)
  l.login()
}
