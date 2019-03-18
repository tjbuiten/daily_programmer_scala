// Functions that take and return a integer
def addTwo(number: Integer): Integer = number + 2
def subtractTwo(number: Integer): Integer = number - 2

// Function that takes a string and returns a integer
def addTwoInputString(number: String): Integer = number.toInt + 2

// Function that takes a integer and returns a string
def addTwoReturnString(number: Integer): String = (number + 2).toString

// Function that takes a integer and a function and returns the function
def higherOrderFunction(number: Integer, aFunction: Integer=>Integer): Integer = {
  aFunction(number)
}

higherOrderFunction(2, addTwo)
higherOrderFunction(2, subtractTwo)

/**
  * These two options are not allowed cause they do not match
  * the Integer=>Integer signature set in the higherOrderFunction method
  * higherOrderFunction(2, addTwoInputString)
  * higherOrderFunction(2, addTwoReturnString)
  **/