//VALUES are immutable constants
val hello: String = "Hola"

//VARIABLE are mutable
var hellothere: String = hello
hellothere = hello + " There!"
print(hellothere)

val immutablehellothere = hello + " There!"
print(immutablehellothere)

//Data Types

val numberOne: Int = 1
val truth: Boolean = true
val letterA: Char = 'a'
val pi: Double = 3.142
val piSinglePrecision: Float = 3.142f
val bigNumber: Long = 12345677
val samllNumber: Byte = 127

println("Here is a mess: " + numberOne + truth + pi + bigNumber)

println(f"Pi is about $piSinglePrecision%.3f")
println(f"Zero padding on the left:  $numberOne%05d")

println(s"I can use the s prefix to use variables like $numberOne $truth $letterA")

println(s"The s prefix isn't limited to variable; I can include expression. LIke ${1+2}")

val ultimateAnswer: String = "To Life, the universer, and everything is 42."
val pattern = """.* ([\d]+).*""".r
val pattern(answerString) = ultimateAnswer
val answer: Int = answerString.toInt
println(answer)

//Boolean
val isGreater = 1 > 2
val islesser = 1 <2
val impossible = isGreater & islesser
val anotherWay = isGreater && islesser
val anotherWay2 = isGreater || islesser

val picard : String = "Picard"
val bestCaptain : String = "Picard"
val isBest: Boolean = picard == bestCaptain
