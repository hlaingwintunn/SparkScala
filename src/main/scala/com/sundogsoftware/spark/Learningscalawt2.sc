//Flow Control

// If else

if(1 > 3) {
  println("impossible")
  println("Really?")
} else {
  println("The world makes sense")
}

//Matching

val number: Int = 2

number match {
  case 1 => println("One")
  case 2 => println("Two")
  case 3 => println("Three")
  case _ => println("Something Else")
}

for(x <- 1 to 4) {
  val square = x * x;
  println(square)
}

var x = 10
while (x >= 0) {
  print(x)
  x -= 1
}

x =0
do {println(x); x+=1} while (x <= 10)

// Expression

{val x = 10; x + 20}