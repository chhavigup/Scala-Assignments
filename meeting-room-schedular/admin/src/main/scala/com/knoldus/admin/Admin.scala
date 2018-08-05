
package com.knoldus.admin
import org.slf4j.LoggerFactory

class Admin {

  val logger = LoggerFactory.getLogger(classOf[Admin])

  def checkUserCredentials(employeeId: Int, name: String, phoneNumber: String): Int= {
    if (employeeId != 0 && name != null && phoneNumber != null && phoneNumber.length == 10)
      1
    else 0
  }

 /* def removeUser() = {

  }

  def updateUserDetails() = {

  }*/
}
object t extends App{
  val a=new Admin()
}


