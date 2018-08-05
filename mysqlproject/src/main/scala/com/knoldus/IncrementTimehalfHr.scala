package com.knoldus

class IncrementTimehalfHr {

  def increment(time:String):String={

    val exit_time = Array('z','a',':','c','d')
    val stringLength = time.size
     exit_time(4)=time(stringLength-1)

    if ((time(stringLength - 2).toInt + 3) >= '6'.toInt) {
      exit_time(3)=(time(stringLength - 2)+3-6).toChar
      exit_time(2)=':'

      if (time(stringLength - 4) == '2') {
        exit_time(1)='1'
        exit_time(0)='0'
      }
      else {
        exit_time(1)=(time(stringLength-4)+1).toChar
        exit_time(0)=time(stringLength-5)
      }
    }
    else {
      for (i <- 0 until stringLength) {
        if (i == 3)
          exit_time(i) = (time(i) + 3).toChar
        else
          exit_time(i) = time(i)
      }
    }
    var y=""
    for (i<- exit_time)
    {
      y+=i
    }
    y
  }

}
