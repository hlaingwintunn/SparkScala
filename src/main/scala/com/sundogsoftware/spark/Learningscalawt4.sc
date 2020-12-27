// Data Structures

//Tuples, Immutable Lists

val captainStuff = ("Picard", "Enterprise-D", "NCC-1701-D")
println(captainStuff)

//Refer to the Individual Field with a ONE-BASED Index
println(captainStuff._1)
println(captainStuff._2)
println(captainStuff._3)

val picardship = "Picard" -> "Enterprise-D"
println(picardship._2)

val aBunchOfStuff = ("Kirk", 1964, true)

//Lists
// Like a Tuple, but more functionality
//must be the same type
var shipList = List("Enterprise", "Defaint", " Voyager", "Deep Space Nine")
println(shipList(1))

println(shipList.head)
println(shipList.tail)

for(ship <- shipList) {println(ship)}

val backwardShips = shipList.map((ship: String) => {ship.reverse})
for(ship <- backwardShips) {println(ship)}

// reduce to combine together all the items in a collection using
val numberList = List(1,2,3,4,5)
val sum = numberList.reduce((x: Int, y: Int) => x + y)
println(sum)

//filter() removes stuff
val iHateFive = numberList.filter((x: Int) => x !=5)
val iHateThree = numberList.filter(_ != 3)

//Concatenate lists
val moreNumbers = List(6,7,8)
val lotsOfNumbers = moreNumbers ++ moreNumbers

val reversed = numberList.reverse
val sorted = reversed.sorted
val lotsOfDuplicates = numberList ++ numberList
val distinctValues = lotsOfDuplicates.distinct
val maxValue = numberList.max
val TotalValue = numberList.sum
val hasThree = iHateThree.contains(3)

//Maps
val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D")
print(shipMap("Picard"))
print(shipMap.contains("Archer"))
val archership = util.Try(shipMap("Archer"))getOrElse("unKnown")
println(archership)