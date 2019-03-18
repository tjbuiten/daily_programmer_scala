/**
In the teachersNeededForSO the system has to keep track
  of the result from each individual call to the function
  in order to calculate the final result. Using the
  teachersNeededForTR prevents this by simply calling the
  next iteration without having to add the result of this
  iteration to anything
  **/

// Example which would lead to a stackoverflow
def teachersNeededForSO(numberOfStudents: Int): Int = {
  if (numberOfStudents <= 30)
    1
  else
    1 + teachersNeededForSO(numberOfStudents - 30)
}

// Example modified to use tail recursion to prevent the stackoverflow
def teachersNeededForTR(numberOfStudents: Int, result:BigInt = 0): BigInt = {
  if (numberOfStudents <= 30)
    result + 1
  else
    teachersNeededForTR(numberOfStudents - 30, result + 1)
}

// Personal implementation of tail recursion
def uselessFunctionUsingTailRecursion(number: Integer): Integer = {
  if (number <= 0)
    number
  else
    uselessFunctionUsingTailRecursion(number - 1)
}