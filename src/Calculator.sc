import scala.io.StdIn.readLine

val Array(valueOne, valueTwo) = readLine("Please give the numbers you want to execute the function on seperated by a comma and an empty space (, ) : \n").split(", ").map(_.toInt)
val function = readLine("Please state the function you want to execute, available options consist of: \n + \n - \n * \n / \n ^ \n")
val result = function match {
  case "+" => valueOne + valueTwo
  case "-" => valueOne - valueTwo
  case "*" => valueOne * valueTwo
  case "/" => valueOne / valueTwo
  case "^" => valueOne ^ valueTwo
}

println("Result: " + result)
