
package db

import java.sql.{Connection, Statement}

class Tables(val database:Database){
  val connection: Connection = database.createConnection()
  val statement: Statement =connection.createStatement
  def signUpTable():Unit={
    val signUp:String = "CREATE TABLE EMPLOYEEDETAILS " +
      "(empId INTEGER not NULL, " +
      " empName VARCHAR(255), " +
      " phoneNumber VARCHAR(255), " +
      " PRIMARY KEY ( empId ))"
      statement.executeUpdate(signUp)

  }
  def roomTable():Unit={
    val room:String = "CREATE TABLE ROOMDETAILS " +
      "(roomId INTEGER not NULL, " +
      " roomName VARCHAR(255), " +
      " roomType VARCHAR(255), " +
      " PRIMARY KEY ( roomId ))"
    statement.executeUpdate(room)
  }
  def meetingRoomAllocation():Unit={
    val roomAllocation:String = "CREATE TABLE MEETINGROOM " +
      "(empId INTEGER not NULL, " +
      " roomId INTEGER, " +
      " timeDuration VARCHAR(255), " +
      " getTime VARCHAR(255), "+
       "empSize INTEGER, "+
      " PRIMARY KEY ( empId), "+" FOREIGN KEY (roomId) REFERENCES ROOMDETAILS(roomId)) "
    statement.executeUpdate(roomAllocation)
  }

  def conferenceRoomAllocation():Unit={
    val roomAllocation:String = "CREATE TABLE CONFERENCEROOM " +
      "(empId INTEGER not NULL, " +
      " roomId INTEGER, " +
      " timeDuration VARCHAR(255), " +
      "date DATE, "+
      "empSize INTEGER, "+
      " PRIMARY KEY ( empId) FOREIGN KEY (roomId) REFERENCES ROOMDETAILS(roomId)) "
    statement.executeUpdate(roomAllocation)
  }

}
object test extends App{
  val d=new Database
  val e=new Tables(d)
  e.meetingRoomAllocation()
}
