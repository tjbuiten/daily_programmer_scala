/**
  * Write a function that returns a closure that prepends any string with the sequence number
  * of the message and prints it on the console. It should display the behavior below. What
  * could you use this closure for?
  */
def makeLogger(): String => Unit = {
  var count = 0

  message: String => {
    count += 1
    println(count + ": " + message)
  }
}

val log: Unit = makeLogger()

/**
  * Write a closure that behaves as a counter (see example in the slides). However, now let the
  * function return two functions, one for incrementing the counter and the other for
  * decrementing the counter. It should display the following behavior.
  */
def counter(): (() => Int, () => Int) = {
  var count = 0

  def increment(): Int = {
    count += 1
    count
  }

  def decrease(): Int = {
    count -= 1
    count
  }

  (increment, decrease)
}

val (incr, decr): (() => Int, () => Int) = counter()
incr() // 1
incr() // 2
decr() // 1
incr() // 2
decr() // 1
decr() // 0

/**
  * Write a function createMemory with signature ‘() => String => String’ that displays the
  * following behavior.
  */
def createMemory(): String => String = {
  var text = ""

  def getText(newText: String): String = {
    val returnText = text
    text = newText
    returnText
  }

  getText
}

val remember: String => String = createMemory()
remember("Hello") // returns ""
remember("World") // returns "Hello"
remember("") // returns "World

/**
  * Write a function range() with signature ‘(Int, Int, Int) => () => Option[Int]’ to implement a
  * range. The first integer is the start, second the end and the third the step. It should work in
  * the following way.
  */
def range(c: Int, m: Int, s: Int): () => Option[Int] = {
  var current = c - s
  val max = m
  val steps = s

  def Step(): Option[Int] = {
    if (current + steps > max) {
      return None
    }
    current += steps
    Some(current)
  }

  Step
}

val myRange = range(10, 20, 3)
myRange() // Some(10)
myRange() // Some(13)
myRange() // Some(16)
myRange() // Some(19)
myRange() // None
myRange() // None