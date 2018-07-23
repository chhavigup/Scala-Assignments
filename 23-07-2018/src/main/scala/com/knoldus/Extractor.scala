package com.knoldus




  object URL {


    def apply(protocal: String, domain: String, path: String, params: Map[String, String]): String = {
      val string = params.map { case (k, v) => k + "=" + v }.mkString("&")
      protocal + "://" + domain + "/" + path + "?" + string

    }


    def unapply(url: String): Option[(String, String, String, Map[String, String])] = {


      val protocal = url.split("://")
      val domain = protocal(1).split("/", 2)
      val path = domain(1).split("\\?")
      val params = path(1).split("&").map(

        value => {
          val remaningValue = value.split("=")
          remaningValue(0) -> remaningValue(1)
        }).toMap
      Some(protocal(0), domain(0), path(0), params)


    }
  }

  /*object main extends App {
    val url: String = URL(" https", "aws.amazon.com", "/console/home", Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112"))
    println(url)


    url match {
      case URL(protocal, domain, path, params) => println(s"Protocal : $protocal \n  domain : $domain \n  path :$path \n params:$params ")

      case _ => println("not an url")
    }
  }*/
class Extractor {
    val url: String = URL(" https", "aws.amazon.com", "/console/home", Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112"))


    def callUnapply(s: String): String = {
      url match {
        case URL(protocal, domain, path, params) => s"Protocal : $protocal \n  domain : $domain \n  path :$path \n params:$params "
        case _ => "not an url"
      }
    }
  }





