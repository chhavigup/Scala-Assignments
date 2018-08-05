package com.knoldus

class IncrementTime2Hr {
  def increment(time:String):String={
    val exit_time = Array('z', 'a', ':', 'c', 'd')
    val stringLength = time.size

    exit_time(4) = time(stringLength - 1)
    exit_time(3) = time(stringLength - 2)
    exit_time(2) = time(stringLength - 3)
    if (time(stringLength - 4).toInt == '8'.toInt) {
      exit_time(1) = '0'
      exit_time(0) = '2'
    }
    else if (time(stringLength - 4).toInt == '9'.toInt) {
      exit_time(1) = '1'
      exit_time(0) = '2'
    }
    else {
      exit_time(1) = (time(stringLength - 4) + 2).toChar
      exit_time(0) = time(stringLength - 5)
    }
    var x = ""
    for (i <- exit_time) {
      x += i
    }
    x
  }
}
