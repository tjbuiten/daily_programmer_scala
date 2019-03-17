import scala.io.Source
import scala.io.StdIn.readLine
import scala.util.control._
import java.io._

def Register(): Unit = {
  val Array(username, password) = readLine("Please state your username and password split by a comma and a space (, ) :\n").split(", ")

  val writer = new BufferedWriter(
    new FileWriter("userData.txt", true) //Set true for append mode
  )

  writer.newLine()
  writer.write(username + ";" + password)
  writer.close()
}

def Login(): Boolean = {
  val Array(givenUsername, givenPassword) = readLine("Please state your username and password split by a comma and a space (, ) :\n").split(", ")
  val filename = "userData.txt"
  val loop = new Breaks

  loop.breakable {
    for (line <- Source.fromFile(filename).getLines) {
      val Array(username, password) = line.split(";")
      if (givenUsername == username && givenPassword == password) {
        return true
      }
    }
  }

  false
}

val function = readLine("Do you want to 'login' or 'register':\n")

function match {
  case "login" =>
    if(Login()) {
      println("logged in!")
    }
    else {
      println("log in failed")
    }
  case "register" => Register()
}