
package com.knoldus.singUp
import scala.io.StdIn.{readLine,readInt}
import org.slf4j.LoggerFactory
import com.knoldus.admin.Admin
import db.{InsertData,Database,Tables}
class  SignUp {

  val logger = LoggerFactory.getLogger(classOf[SignUp])

  def addDetails(admin: Admin,insert:InsertData): Unit = {
    logger.info("Enter the name of the user")
    val name = readLine()
    logger.info("Enter Employee Id")
    val employeeId = readInt()
    logger.info("Enter Employee PhoneNumber")
    val phoneNumber=readLine()
    val check=admin.checkUserCredentials(employeeId,name,phoneNumber)
    if(check==1)
      insert.insertEmployeeDetails(employeeId,name,phoneNumber)
  }

}



object test extends App{
  val d=new Database
  val a=new Admin()
  //val t=new Tables(d)
  //t.signUpTable()
  val i=new InsertData(d)
  val s=new SignUp()
  s.addDetails(a,i)
}
