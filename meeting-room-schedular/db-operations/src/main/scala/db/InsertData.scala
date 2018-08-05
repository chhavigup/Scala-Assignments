
package db

import java.sql.{Connection, Statement}

class InsertData(val database: Database) {
  val connection: Connection = database.createConnection()
  val statement: Statement = connection.createStatement
  def insertEmployeeDetails(empId: Int, empName: String, empNumber: String): Unit = {

    statement.executeUpdate("insert into EMPLOYEEDETAILS values('"+empId+"','"+empName+"',"+empNumber+")")

  }
  def insertRoomDetails():Unit={
    statement.executeUpdate("insert into ROOMDETAILS values(1,'A','Meeting')")
    statement.executeUpdate("insert into ROOMDETAILS values(2,'B','Meeting')")
    statement.executeUpdate("insert into ROOMDETAILS values(3,'C','Meeting')")
    statement.executeUpdate("insert into ROOMDETAILS values(4,'D','Meeting')")
    statement.executeUpdate("insert into ROOMDETAILS values(5,'E','Meeting')")
    statement.executeUpdate("insert into ROOMDETAILS values(6,'Conference-Hall','Conference')")

  }

  def meetingRoomAllocation(empId:Int,roomId:Int,duration:String,time:String,size:Int): Int ={
    statement.executeUpdate("insert into MEETINGROOM values('"+empId+"','"+roomId+"',"+duration+",'"+time+"','"+size+"')")
    //statement.executeUpdate("insert into MEETINGROOM values(2,'Hope','Normal')")


  }
}
/*object t extends App{
  val d=new Database
  val i =new InsertData(d)
  i.meetingRoomAllocation()
}
*/