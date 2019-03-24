import scala.math.sqrt

/**
  * Write functions that return an Option with the following behavior (use recursion and pattern
  * matching).
  * i. Returns the first element in a list. List[Int] => Option[Int]
  * ii. Returns the largest element in a list. List[Int] => Option[Int]
  * iii. Replicate a string a number of times (Option[String], Option[Int]) => Option[String]
  **/
object OptionEnum extends Enumeration {
  type option = Value
  val First, Largest, Replicate = Value
}

def superCoolFunction(list: List[Int], option: OptionEnum.Value, string: Option[String], times: Option[Int]): Either[Option[Int], Array[String]] = {
  option match {
    case OptionEnum.First => Left(Some(list.head))
    case OptionEnum.Largest => Left(Some(list.max))
    case OptionEnum.Replicate =>
      string match {
        case Some(value) => Right(Array.fill(times.get)(value))
        case None => throw new RuntimeException()
      }
  }
}

/**
  * Write the following three functions that have signature Either[Int, String] => Either[Int,
  * String]. Each of the functions can return in the error state (Right). Test a composition (any
  * order you like) of the three functions with these three inputs: Left(0), Left(-2), Left(1). Each
  * of the inputs should produce an error that propagates through to the end.
  * i. Square root of x (error when input is negative)
  * ii. Divide 10 by x (error when input is zero)
  * iii. Divide 1 by x – 1 (error when input is one)
  **/
def squareRoot(either: Either[Int, String]): Either[Int, String] = {
  either match {
    case Right(x) => Right(x)
    case Left(x) if x < 0 => Right("CANT GET")
    case Left(x) if x >= 0 => Left(sqrt(x.toDouble).toInt)
  }
}