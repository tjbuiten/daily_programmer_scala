import scala.io.StdIn.readLine
import java.io._

val Array(name,age,username) = readLine("Please state your name, age and reddit username seperated by a comma and an empty space (, ) :\n").split(", ")
println("your name is " + name + " you are " + age + " years old, and your username is " + username)

val writer = new BufferedWriter(
  new FileWriter("userData.txt", true)  //Set true for append mode
)

writer.newLine()
writer.write("your name is " + name + " you are " + age + " years old, and your username is " + username)
writer.close()
