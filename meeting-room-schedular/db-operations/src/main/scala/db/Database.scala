
package db
import java.sql.DriverManager
import java.sql.Connection

class Database {

  var connection:Connection= _
  def createConnection(): Connection = {

        val url = "jdbc:mysql://localhost:3306/roomScheduler"
        val userName = "root"
        val password = "root"
        val driver =  "com.mysql.jdbc.Driver"
     try{
          Class.forName(driver)
          connection = DriverManager.getConnection(url, userName, password)
          connection
     }

   }
}

