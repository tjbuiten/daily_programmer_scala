import scala.collection.mutable.ListBuffer

/**
  * Write a function swap(tuple: (Int, String)) => (String, Int) that takes a tuple (Int, String) and
  * swaps them around using tuple deconstruction.
  **/
def swap(tuple: (Int, String)): (String, Int) = {
  val (integer, string) = tuple
  (string, integer)
}

/**
  * Write a function doubleHead(list: List[Int]) => List[Int] that takes a list, and returns that same
  * list, but with the first element multiplied by two. Use list deconstruction.
  **/
def doubleHead(list: List[Int]): List[Int] = {
  val h::t = list
  h*2::t
}

/**
  * Write a function add (x:Int) => (y:Int) => Int that returns a function which returns x + y
  **/
def combine(x: Int, y: Int): Int = x + y
def add(x: Int, y: Int): Int = combine(x, y)

/**
  *Write a function multiplyBy (x:Int) => (y:Int) => Int that returns a function which returns x * y
  **/
def multiply(x: Int, y: Int): Int = x * y
def multiplyBy(x: Int, y: Int): Int = multiply(x, y)

/**
  * Write a function applyFunc(x:Int, y:Int, f:(Int, Int) => Int) => Int which applies the function f
  * to x and y.
  **/
def applyFunc(x: Int, y: Int, f: (Int, Int) => Int): Int = f(x, y)

/**
  *Write a function sizeDescription(List[Int]) => String that
  * i. returns "short" if the list contains less than 10 elements
  * ii. else returns "long" if the list contains less than 100 elements
  * iii. else returns "very long"
  **/
def sizeDescription(list: List[Int]): String = {
  list.size match {
    case a if a < 10 => "short"
    case b if 10 to 100 contains b => "long"
    case c if c >= 100 => "very long"
  }
}

/**
  * Write a function zip(List[Int], List[Int]) => List[(Int, Int)] that pairs together the two list into a
  * new list of (Int, Int) tuples.
  * Example: zip(List(1, 2 , 3), List(5, 4, 3)) results in List((1, 5), (2, 4), (3, 3))
  **/
def fd(a: List[Int], b: List[Int]): List[(Int, Int)] = {
  var aCopy = a
  var bCopy = b
  val returnMe = new ListBuffer[(Int, Int)]

  for (i <- 0 to a.size) {
    val ahead::atail = aCopy
    val bhead::btail = bCopy
    var add = (ahead, bhead)
    returnMe += add
    aCopy = atail
    bCopy = btail
  }
  returnMe.toList
}

/**
  * Write a function that computes the total amount on the bill at a bar. The function takes two
  * lists and a discount strategy. The first list contains the number of drinks, the second list the
  * price per drink. For example: two beers and three coke result in the following lists: List(2, 3)
  * and List(3.0, 2.5). The total price without discount would be 2*3.0 + 3*2.5 = 13.5. The third
  * parameter to the function is a discount strategy, which is of type (Int, Double) => Double.
  * This function returns the price including discount for one kind of drink. For example given
  * the 2 beers of 3.0 each it returns 6.0 for the full price. Implement the following discount
  * strategies:
  *  i. Full price
  *  ii. 10% discount
  *  iii. Happy hour: every second drink of the same kind is for free
  **/
def fullPrice(amount: Int, price: Double): Double = amount * price

def tenPercent(amount: Int, price: Double): Double = (amount * price) * 0.9

def happyHour(amount: Int, price: Double): Double = math.floor(amount / 2) * price

def calculateBill(drinks: List[String], price: List[Double], calculateDiscount: (Int, Double) => Double): Double = {
  val drinksCopy = new ListBuffer[String]()
  drinksCopy.insertAll(drinks.size, drinks)

  var priceTotal = 0.0

  var i = 0

  while (i < drinksCopy.size) {
    var amount = 0
    val price = price(i)
    var j = 0

    while (j < drinksCopy.size) {
      if (drinks(j) == drinksCopy(i)) {
        amount += 1
        drinksCopy.remove(j)
        j -= 1
        i -= 1
      }
      j += 1
    }

    priceTotal += calculateDiscount(amount, price)
    i += 1
  }
  priceTotal
}
