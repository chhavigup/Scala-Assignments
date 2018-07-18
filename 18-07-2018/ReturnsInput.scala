package com.knoldus.edu

class ReturnsInput {

  def matching(valType: Any): String = valType match {
    case s: String => s"you provided me this string $s"
    case i: Int =>s"thanks for the int $i"
    case f: Float => s"Thanks for the float  $f"
    case a: Array[Int] =>  s"you provided an array ${a.mkString(" ,")} "
    case as: Array[String] => s"you provided an array of String ${as.mkString(" ,")} "
    case list: List[_] => s"thanks for the list :- ${list.toString()}"
    case m: Map[_, _] => s"you provided a map ${m.toString()}"
    case n: Pet => s"My pet name is $n"
  }

}
 case class Pet(name:String)
