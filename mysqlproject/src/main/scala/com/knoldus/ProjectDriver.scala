package com.knoldus

object ProjectDriver extends App {

  println("Please Select Room Type")
  println("Please Make Sure if you choose Conference Room than your team size must be greater than 6")
  println(" 1. Meeting Room \n 2. Conference Room \n")
  val room_type=scala.io.StdIn.readInt()
  println(room_type)
  room_type match {
    case 1 =>getMeetingRoomDetail()
    case 2 =>getConferenceRoomDetail()
  }

  def getMeetingRoomDetail()={
    println("Require For Individual or Group")
    println(" 1.Individual \n 2. Group \n")
    val x=scala.io.StdIn.readInt()
    println("Enter Your Employee Id")
    val EID=scala.io.StdIn.readInt()
    println("Enter Your Lead or Your Name")
    val Ename=scala.io.StdIn.readLine()
    println("Enter Date(YYYY-MM-DD) on which you require room")
    val date=scala.io.StdIn.readLine()
    println("Enter Your Entry Time(24hr format)between 10:00 to 18:30 ")
    val time=scala.io.StdIn.readLine()
    if(x==1) {
      val Exit_time = new IncrementTimehalfHr().increment(time)
      //println(Exit_time)
      val mr=new MeetingRoom(EID,time,Exit_time,Ename,date,false).checkAvailablity()
    }
    else if(x==2){
      val Exit_time=new IncrementTime2Hr().increment(time)
      //println(Exit_time)
      val mr=new MeetingRoom(EID,time,Exit_time,Ename,date,true).checkAvailablity()
    }
  }

  def getConferenceRoomDetail()={

    println("Enter Your Group Id")
    val GID=scala.io.StdIn.readInt()
    println("Enter Your Lead Name")
    val Lname=scala.io.StdIn.readLine()
    println("Enter Date(YYYY-MM-DD) on which you require room")
    val date=scala.io.StdIn.readLine()
    println("Enter Your Entry Time(24hr format) between 10:00 to 18:30 ")
    val time=scala.io.StdIn.readLine

    val exit_time = Array('z','a',':','c','d')
    val stringLength = time.size

    exit_time(4) =time(stringLength - 1)
    exit_time(3) =time(stringLength - 2)
    exit_time(2) =time(stringLength - 3)
    if (time(stringLength - 4).toInt == '8'.toInt) {
      exit_time(1) = '0'
      exit_time(0) = '2'
    }
    else if( time(stringLength - 4).toInt == '9'.toInt)
    {
      exit_time(1) = '1'
      exit_time(0) = '2'
    }
    else
    {
      exit_time(1) = (time(stringLength - 4)+2).toChar
      exit_time(0) = time(stringLength - 5)
    }
    var x=""
    for (i<- exit_time)
    {
      x+=i
    }
    val Exit_time=x
    val croom=new ConferenceRoom(GID,time,Exit_time,Lname,date).checkAvailablity()
    if(!croom)
      {
        println("\nSorry we can not allocate you conference room again today")
      }
    else
      {

      }

  }

}
