/**
  * Write a curried version of the following function. Call it with the same arguments
  *
  * def concat(name: String, age: String, profession: String): String =
  * name + " is " + age + " years old and is a " + profession
  */
//def concat(name: String): Int => String => String = {
//  age: Int =>
//    profession: String =>
//      name + " is " + age + " years old and is a " + profession
//}

def concat(name: String)(age: Int)(profession: String): String = name + " is " + age + " years old and is a " + profession

concat("Alfred")(21)("programmer")

/**
  * Use the curried version of concat (exercise 1) to get a function that only takes the profession
  * of 21 year old Alfred.
  **/
var setProfession = concat("Alfred")(21)
setProfession("my profession")

/**
  * Can you use the curried version of concat to produce (exercise 1) a function that takes the
  * name of a 21 year old programmer?
  */
var setName = concat(_: String)(21)("programmer")

/**
  * Write a curried function that takes two arguments, the lucky number and a function
  * strategy of signature () => Int that produces the next guess each time it’s called. This
  * strategy function implements a guessing strategy.
  */
//def lucky(luckyNumber: Int): (() => Int) => Int = {
//  def useStrategy (strategy: () => Int): Int = {
//    strategy()
//  }
//
//  useStrategy
//}

def lucky(luckyNumber: Int)(strategy: () => Int): Int = strategy()

/**
  * Then create a new game on which you can try different strategies. Each game should
  * have the same lucky number (Hint: you can use the curried function to do partial
  * application!
  */
var game = lucky(1)(_: () => Int)
