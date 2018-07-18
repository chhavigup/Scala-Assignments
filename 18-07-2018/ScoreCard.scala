package com.knoldus.edu




  case class Student(id: Int, name: String, division: Int, section: Char)

  case class ScoreCard(id: Int, subject1: Float, subject2: Float, subject3: Float, totalMarks: Float)

  object ScoreCard {
    def apply(id: Int, subject1: Float, subject2: Float, subject3: Float): ScoreCard = {
      val totalMarks = subject1 + subject2 + subject3
      new ScoreCard(id, subject1, subject2, subject3, totalMarks)

    }

  }

  class ReportCard {


    def findFirstThreeToppers(listOfStudents: List[Student], listOfScoreCard: List[ScoreCard]): List[Any] = {

      if (listOfStudents.size >= 3) {
        val topperList = listOfScoreCard.sortWith(_.totalMarks > _.totalMarks).take(3).map(_.id)
        val topperName = topperList.map {
          sid => listOfStudents.filter(_.id == sid).head
        }

        topperName.map { e =>
          (e.id, e.name)
        }
      }

      else
        throw new IllegalArgumentException
    }

    def findSubjectTopper(subject: String, listOfStudents: List[Student], listOfScoreCard: List[ScoreCard]): (Int, String, Float, Float, Float, Float) = {

      val subjectTopper = subject match {
        case "subject1" => listOfScoreCard.sortWith(_.subject1 > _.subject1).head
        case "subject2" => listOfScoreCard.sortWith(_.subject2 > _.subject2).head
        case "subject3" => listOfScoreCard.sortWith(_.subject3 > _.subject3).head
      }
      val topperDetails = listOfStudents.filter(_.id == subjectTopper.id).head

      (subjectTopper.id, topperDetails.name, subjectTopper.subject1, subjectTopper.subject2, subjectTopper.subject3, subjectTopper.totalMarks)
    }


    def displayMarksheet(sid: Int, listOfStudents: List[Student], listOfScoreCard: List[ScoreCard]): Unit = {

      val scoreCard = listOfScoreCard.filter(_.id == sid).head
      val studentInfo = listOfStudents.filter(_.id == sid).head

      println(s"ID : $sid \n Name : ${studentInfo.name} \n MARKS : \n  SUBJECT : \n SUBJECT1 : ${scoreCard.subject1} \n SUBJECT2 : ${scoreCard.subject2} \n SUBJECT3 : ${scoreCard.subject3} \n TOTAL MARKS : ${scoreCard.totalMarks}")
    }


  }


  object mainObject {
    def main(args: Array[String]): Unit = {

      val student: List[Student] = List(Student(1, "Bob", 11, 'A'), Student(2, "Dab", 10, 'C'), Student(3, "Tab", 10, 'C'))

      val scoreCard: List[ScoreCard] = List(ScoreCard(1, 88.0f, 45.0f, 79.0f), ScoreCard(2, 67.0f, 80.0f, 45.0f), ScoreCard(3, 99.0f, 87.0f, 85.0f))
      val obj = new ReportCard
      obj.displayMarksheet(1, student, scoreCard)
      obj.displayMarksheet(2, student, scoreCard)
      obj.displayMarksheet(3, student, scoreCard)
      obj.findFirstThreeToppers(student, scoreCard)
      obj.findSubjectTopper("subject1", student, scoreCard)
      obj.findSubjectTopper("subject2", student, scoreCard)
      obj.findSubjectTopper("subject3", student, scoreCard)


    }
  }










