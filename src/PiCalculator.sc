var pi: Double = 0
var i = 0
for (i <- 0 to 1000) {
  if (i % 2 == 0) {
    pi = pi + (1 / (1 + (2 * i)).toDouble)
  }
  else {
    pi = pi - (1 / (1 + (2 * i)).toDouble)
  }
}
pi *= 4
println(pi)
