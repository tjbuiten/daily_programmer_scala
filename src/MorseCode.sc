import scala.collection.mutable.ListBuffer

def matchMorse (morse: String): String = morse match {
  case ".-" => "A"
  case "-..." => "B"
  case "-.-." => "C"
  case "-.." => "D"
  case "." => "E"
  case "..-." => "F"
  case "--." => "G"
  case "...." => "H"
  case ".." => "I"
  case ".---" => "J"
  case "-.-" => "K"
  case ".-.." => "L"
  case "--" => "M"
  case "-." => "N"
  case "---" => "O"
  case ".--." => "P"
  case "--.-" => "Q"
  case ".-." => "R"
  case "..." => "S"
  case "-" => "T"
  case "..-" => "U"
  case "...-" => "V"
  case ".--" => "W"
  case "-..-" => "X"
  case "-.--" => "Y"
  case "--.." => "Z"
}

def convertToAlphabetic (characters: List[String], word: String, words: List[String], text: StringBuffer[String]): String = {
    if (characters.length == 0) {
      val h::t = words

      convertToAlphabetic(h, "", t, text)
    }
}

def splitMorseIntoWords (morse: String): ListBuffer[String] = {
  val characters = morse.split("")
  var word = ""
  var words = ListBuffer[String]

  for (i <- 0 to characters.length) {
    if (characters(i) == "/")
      words += word
    else
      word += characters(i)
  }

  words
}