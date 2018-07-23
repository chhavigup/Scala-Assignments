package com.knoldus

class Expression {
def check(id: String):Option[(String,String)] = {
  val email =  """^([A-Z0-9a-z._%+-]+)@([A-Z0-9a-z._%+-]+[.]+[A-Z0-9a-z._%+-]+)$""".r
  id match {
    case email(user,domain) => Some(user,domain)
    case _ => None
  }

}
}
