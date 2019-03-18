import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine

val people = List("Alfred","Boris","Ann","Jan","Anya","Monique", "Christophe", "Jan", "Joris", "Bert", "Olaf")

/**
  * Add "Dear " in front of each name.
  * Result: List[String]
  **/
def addDear (list: List[String]): List[String] = {
  val listCopy = new ListBuffer[String]
  list.foreach(item => {
    listCopy += "Dear " + item
  })
  listCopy.toList
}

/**
  * Create a function (String) => String that add "Dear " in front of the string
  * Apply this function to each name and print the result for each name to console on a
  * separate line.
  * Result: Unit. The result is only shown in console.
  **/
addDear(people).foreach { println }

/**
  * Show a list of all letters (including doubles)
  * Result: List[Char]
  **/
def splitIntoCharacters(text: String): Array[Char] = text.toCharArray

/**
  * Show a list of all unique letters (Case)
  * Result: List[Char]
  */
def splitIntoUniqueCharacters(text: String): Array[String] = text.split("").distinct

/**
  * Add together the size of all names
  * Result: Int
  **/
def getNameSize(names: Array[String]): Int = {
  var length = 0
  names.foreach(name => {
    length += name.split("").length
  })
  length
}

/**
  * Create the string "Dear <name1>, <name2>, ..., <nameN>, "
  * Use .fold
  * Result: String
  **/
def combineString(strings: Array[String]): String = strings.foldLeft(people.head)(_+ ", " +_)

/**
  * How many people have 'an' (case-insensitive) in their name?
  * Result: Int
  **/
def countAn(strings: Array[String]): Int = {
  var count = 0
  strings.foreach(text => {
    if (text.toLowerCase().contains("an"))
      count += 1
  })
  count
}

/**
  * How many names are 3 letters long?
  * Result: Int
  **/
def countThreeLength(strings: Array[String]): Int = {
  var count = 0
  strings.foreach(text => {
    if (text.split("").length == 3)
      count += 1
  })
  count
}

/**
  * Do all names contain a capital letter?
  * Use .forall
  **/
def checkIfContainsCapital(text: String): Boolean = {
  text.toArray.foreach(character => {
    if (character.isUpper)
      return true
  })
  false
}

def doAllNamesContainCapital(strings: Array[String]): Boolean = {
  people.foreach(name => {
    if(!checkIfContainsCapital(name))
      return false
  })
  true
}

/**
  * Is there any name with the letter y or q in it?
  * Use .exists
  * Result: Boolean
  **/
def isNameWithYOrQ(names: Array[String]): Boolean = {
  names.foreach(name => {
    if(name.contains('y') || name.contains('q'))
      return true
  })
  false
}

/**
  * Show all names with the letter y or q in them
  * Result: List[String]
  **/
def getNamesWithYOrQ(names: Array[String]): List[String] = {
  var found = new ListBuffer[String]()
  names.foreach(name => {
    if(name.contains('y') || name.contains('q'))
      found += name
  })
  found.toList
}

/**
  * Can you group the names by their size?
  * Tip: Check .groupBy
  * Result: Map[Int, List[String]
  */
def groupNames(names: Array[String]): Map[Int, Array[String]] = names.groupBy(_.length)

/**
  * Are there duplicate names in the list?
  * Result: Boolean
  */
def containsDuplicates(texts: Array[String]): Boolean = {
  var textsCopy = texts.toList

  for (i <- 0 to textsCopy.length) {
    val head::tail = textsCopy
    if (tail.contains(head)) {
      return true
    }
    textsCopy = tail
  }
  false
}

/**
  * Write the following functions. Use recursion.
  * i. size(List[Int]) => Int
  * ii. sum(List[Int])) => Int
  * iii. max(List[Int])) => Int
  * iv. replicate(String, Int) => String
  **/
def size(list: List[Int]): Int = list.size
def sum(list: List[Int]): Int = {
  var sum = 0
  for(i <- 0 to size(list)) {
    sum += list(i)
  }
  sum
}
def max(list: List[Int]): Int = {
  var max = list.head
  list.tail.foreach(number => {
    if (number > max)
      max = number
  })
  max
}

/**
  * Write a tail recursive function that asks for user input on each loop. It remembers the user’s
  * input until the user types ‘quit’. At that moment it repeats everything the user has typed
  * before. Note that you need to keep a list of everything the user has said, as you won’t go
  * down the function call stack!
  **/
def userInput(list: List[String]): List[String] = {
  val input = readLine("to quit type quit, to continue type anything else")
  if (input == "quit")
    return list
  userInput(list :+ input)
}
