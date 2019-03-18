// Returns the first variable from the array
def getHeadOfList(list: List[Integer]): Integer = {
  val head::tail = list
  head
}

// Returns an array containing everything except from the first variable in the array
def getTailOfList(list: List[Integer]): List[Integer] = {
  val head::tail = list
  tail
}