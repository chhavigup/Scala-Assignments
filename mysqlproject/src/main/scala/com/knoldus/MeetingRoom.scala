package com.knoldus

class MeetingRoom (Employee_Id:Int,Entry_time:String,Exit_time:String,Lead_Name:String,Date:String,Team:Boolean){

  def checkAvailablity(): Boolean =
  {
    val r1=new DuplicateMeeting(Date,Employee_Id,"mroom1").checkAvailabilty()
    val r2=new DuplicateMeeting(Date,Employee_Id,"mroom2").checkAvailabilty()
    val r3=new DuplicateMeeting(Date,Employee_Id,"mroom3").checkAvailabilty()
    val r4=new DuplicateMeeting(Date,Employee_Id,"mroom4").checkAvailabilty()
    val r5=new DuplicateMeeting(Date,Employee_Id,"mroom5").checkAvailabilty()

    if(r1 && r2 && r3 && r4 && r5)
      {
        val room1=new Mroom1(Entry_time,Exit_time,Team,Date,Employee_Id).checkAvailability()
        val room2=new Mroom2(Entry_time,Exit_time,Team,Date,Employee_Id).checkAvailability()
        val room3=new Mroom3(Entry_time,Exit_time,Team,Date,Employee_Id).checkAvailability()
        val room4=new Mroom4(Entry_time,Exit_time,Team,Date,Employee_Id).checkAvailability()
        val room5=new Mroom5(Entry_time,Exit_time,Team,Date,Employee_Id).checkAvailability()
        val list=List(room1,room2,room3,room4,room5).sorted
        println("room1=>"+room1)
        println("room2=>"+room2)
        println("room3=>"+room3)
        println("room4=>"+room4)
        println("room5=>"+room5)
          println(list)
        if(Team) {
          val exit_time =new IncrementTime2Hr().increment(list(0))
            list(0) match {
              case x if (room1 == x) => new MeetingRoomInsert().Insertion("mroom1", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room2 == x) => new MeetingRoomInsert().Insertion("mroom2", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room3 == x) => new MeetingRoomInsert().Insertion("mroom3", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room4 == x) => new MeetingRoomInsert().Insertion("mroom4", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room5 == x) => new MeetingRoomInsert().Insertion("mroom5", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
            }
        }
        else
          {
            val exit_time =new IncrementTimehalfHr().increment(list(0))
            list(0) match {

              case x if (room1 == x) => new MeetingRoomInsert().Insertion("mroom1", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room2 == x) => new MeetingRoomInsert().Insertion("mroom2", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room3 == x) => new MeetingRoomInsert().Insertion("mroom3", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room4 == x) => new MeetingRoomInsert().Insertion("mroom4", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)
              case x if (room5 == x) => new MeetingRoomInsert().Insertion("mroom5", list(0), exit_time, Employee_Id, Lead_Name, Date,Entry_time)

            }
          }

      }
    else
    {
      println("Sorry we can not allocate you conference room again today")
    }

    true
  }
}





