import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readInt
import scala.util.Random

def generateCharacters(length: Integer): String = {
  val generator = new Random(System.currentTimeMillis())
  val password = new ListBuffer[Char]()
  val i = 0
  for (i <- 0 to length) {
    if (generator.nextInt(2) == 1) {
      password += (generator.nextInt(9) + 48).toChar
    }
    else {
      password += (generator.nextInt(26) + 65 + 32 * generator.nextInt(2)).toChar
    }
  }

  password.mkString
}

def generatePassword(amount: Integer): List[String] = {
  val passwords = new ListBuffer[String]()
  val i = 0

  for (i <- 1 to amount) {
    println("How long should the password be:\n")
    val length = readInt()
    passwords += generateCharacters(length)
    println(passwords.size)
  }

  passwords.toList
}

println("How many passwords do you want:\n")
val passwords = generatePassword(readInt())

passwords.foreach { println }