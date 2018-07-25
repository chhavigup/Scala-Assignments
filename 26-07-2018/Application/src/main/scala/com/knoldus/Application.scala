package com.knoldus
import java.io.File

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/*
class Assignment1 {
  def listFiles(dir:String):Future[List[File]]= Future {
    def listAllFiles(dir:String):List[File]={
      val files=new File(dir)
      val listall= files.listFiles.toList
        listall.filter(_.isFile)::: listall.filter(_.isDirectory)
        .flatMap(x=>listAllFiles(x.getAbsolutePath))
    }
    listAllFiles(dir)
  }
}
*/

class Application {

  def listFiles(dir: String): Future[List[File]] = Future {
    @tailrec
    def listAllFiles(dir: List[File], list: List[File]): List[File] = {

      if (dir.isEmpty) {
        list
      }
      else {
        val listFilesDir = dir.head.listFiles().toList

        val listFiles = list ::: listFilesDir.filter(_.isFile)

        val listDir =  listFilesDir.filter(_.isDirectory)
        listAllFiles(listDir, listFiles)
      }
    }

    val file = new File(dir)
    val dirL = List(file)

    listAllFiles(dirL, Nil)
  }
}

/*
object Assignment1 extends App{
  val ob = new Application
  val ab = ob.listFiles("/home/knoldus/IdeaProjects/Scala04/src/main/resources")
  Thread.sleep(200)
  print(ab)
}

*/