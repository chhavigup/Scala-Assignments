package com.knoldus


import java.io.File

import org.scalatest.FunSuite
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ApplicationSpec extends FunSuite {

  val obj = new Application

  val listFutureFiles: Future[List[File]] = obj.listFiles("/home/knoldus/Documents/Folder1")

  val file1 = new File("/home/knoldus/Documents/Folder1")
  val file2 = new File("/home/knoldus/Documents/Folder1/Folder3")
  val file3 = new File("/home/knoldus/Documents/Folder1/Folder3")


  test("Test Assignments 1") {

    listFutureFiles.map(x => assert(x == List(file1, file2, file3)))
  }

}

