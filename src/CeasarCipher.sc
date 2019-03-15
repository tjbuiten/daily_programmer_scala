import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

def  encode(text: String): String = {
  val characters = text.toList
  val encoded = new ListBuffer[Char]()
  characters.foreach(character => {
    val number = character.toInt
    if (number > 88 && number <= 90) {
      encoded += ((65 - (90 - number)) + 2).toChar
    }
    else if (number > 120 && number <= 122) {
      encoded += ((97 - (122 - number)) + 2).toChar
    }
    else {
      encoded += (number + 2).toChar
    }
  })

  encoded.mkString
}

def  decode(text: String): String = {
  val characters = text.toList
  val decoded = new ListBuffer[Char]()
  characters.foreach(character => {
    val number = character.toInt
    if (number >= 65 && number < 67) {
      decoded += ((90 + (number - 65)) - 2).toChar
    }
    else if (number >= 97 && number < 99) {
      decoded += ((122 + (number - 97)) - 2).toChar
    }
    else {
      decoded += (number - 2).toChar
    }
  })

  decoded.mkString
}

val inputText = readLine("Post your text:\n")
val inputFunction = readLine("Do you want to decode or encode?: \n")

if (inputFunction == "encode") {
  println(encode(inputText))
} else {
  println(decode(inputText))
}