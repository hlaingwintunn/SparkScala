// Functions

// format def <function name> {parameter name : type...} : return Type = {}

def squareIt(x: Int) : Int = {
  x * x
}

def cubeIt(x: Int) : Int = { x * x * x}

print(squareIt(2))

println(cubeIt(3))

def transformInt(x: Int , f: Int => Int) : Int = {
  f(x)
}

val result = transformInt(2, cubeIt)
print(result)

transformInt(3, x => x * x * x)

transformInt(10, x => x/2)

transformInt(2, x => { val y = x * 2; y * y})

