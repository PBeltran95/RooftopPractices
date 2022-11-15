import java.util.*

fun main() {
    val input = Scanner(System.`in`)


//    for (i in 0..3) println(i)
//    for (i in 0 until 3) println(i)
//    for (i in 2..8 step 2) println(i)
//    for (i in 3 downTo 0) println(i)
//    for (c in 'a'..'d') println(c)
//    for (c in 'z' downTo 's' step 2 ) println(c)


    // ---
//    val alumniCount = 10
//
//    println("We are $alumniCount alumni") // We are 10 alumni
//
//    // ---
//    val firstNumber = 10
//    val secondNumber = 20
//
//    println("The summary is ${firstNumber * secondNumber}") // The summary is 200
//
//    // ---
//    var totalAmount = 20.5
//    totalAmount *= 3
//
//    println("The total amount is $totalAmount")
//
//    // ---
//    val measure = 30.5
//    println("We are at $measure degrees.")
//    println("We are at ${measure + 5} degrees.")
//
//    // ---
//    var teamName: String?
//    var teamCity: String?
//    var teamCups = 0
//
//    teamName = "Rayo Vallecano"
//    teamCity = "Madrid"
//
//    println("I'm proud of my team $teamName which is from $teamCity. They won $teamCups times")
//
//    teamName = "Athletic"
//    teamCity = "Bilbao"
//    teamCups = 35
//    println("I'm proud of my team $teamName which is from $teamCity. They won $teamCups times")
//
//    // ---
//    val task = 32450
//    val pendingTask: Int = 0
//
//    println("I've finished task $task and misses ${pendingTask ?: 0 }")
//
//    // ---
//    val myName: String? = null
//
//    println("My name has ${myName?.length ?: 0} characters")

/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/



//    val trafficLightColor = "Green"
//
//    if (trafficLightColor == "Red") {
//        println("Stop")
//    } else {
//        println("Go")
//    }

//    val trafficLightColor = "Black"
//
//    if (trafficLightColor == "Red") {
//        println("Stop")
//    } else if (trafficLightColor == "Yellow") {
//        println("Slow")
//    } else {
//        println("Go")
//    }



//    val trafficLightColor = "Black"
//
//    if (trafficLightColor == "Red") {
//        println("Stop")
//    } else if (trafficLightColor == "Yellow") {
//        println("Slow")
//    } else if (trafficLightColor == "Green") {
//        println("Go")
//    } else {
//        println("Invalid traffic-light color")
//    }



/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/


//    val x = 3
//
//    when (x) {
//        2 -> println("x is a prime number between 1 and 10.")
//        3 -> println("x is a prime number between 1 and 10.")
//        5 -> println("x is a prime number between 1 and 10.")
//        7 -> println("x is a prime number between 1 and 10.")
//        else -> println("x isn't a prime number between 1 and 10.")
//    }

//    val x = 3
//
//    when (x) {
//        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//        else -> println("x isn't a prime number between 1 and 10.")
//    }


//    val x = 4
//
//    when (x) {
//        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
//        else -> println("x isn't a prime number between 1 and 10.")
//    }

//    val x: Any = 20
//
//    when (x) {
//        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
//        is Int -> println("x is an integer number, but not between 1 and 10.")
//        else -> println("x isn't an integer number.")
//    }
//}

//    val trafficLightColor = "Amber"
//
//    when (trafficLightColor) {
//        "Red" -> println("Stop")
//        "Yellow", "Amber" -> println("Slow")
//        "Green" -> println("Go")
//        else -> println("Invalid traffic-light color")
//    }

//    val trafficLightColor = "Black"
//
//    val message =
//        if (trafficLightColor == "Red") "Stop"
//        else if (trafficLightColor == "Yellow") "Slow"
//        else if (trafficLightColor == "Green") "Go"
//        else "Invalid traffic-light color"
//
//    println(message)

    val trafficLightColor = "Amber"

    val trafficMessage = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Proceed with caution."
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(trafficMessage)


/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/


    /*
     * val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    val luckyNumber = 4

    if (rollResult == luckyNumber) {
        println("You win!")
    } else if (rollResult == 1) {
        println("So sorry! You rolled a 1. Try again!")
    } else if (rollResult == 2) {
        println("Sadly, you rolled a 2. Try again!")
    } else if (rollResult == 3) {
        println("Unfortunately, you rolled a 3. Try again!")
    } else if (rollResult == 5) {
        println("Don't cry! You rolled a 5. Try again!")
    } else {
        println("Apologies! You rolled a 6. Try again!")
    }
    */

    fun getColor(): Color{
        return Color.GREEN
    }

    when (getColor()) {
        Color.RED -> println("red")
        Color.GREEN -> println("green")
        Color.BLUE -> println("blue")
        // 'else' is not required because all cases are covered
    }

    when (getColor()) {
        Color.RED -> println("red") // no branches for GREEN and BLUE
        else -> println("not red") // 'else' is required
    }



    val myFirstDice = Dice(6)
    val rollResult = myFirstDice.roll()
    println("Your ${myFirstDice.numSides} sided dice rolled ${rollResult}!")
    val luckyNumber = 4

    val message = when (rollResult) {
        luckyNumber -> { "You win!" }
        1 -> { "So sorry! You rolled a 1. Try again!" }
        2 -> { "Sadly, you rolled a 2. Try again!" }
        3 -> { "Unfortunately, you rolled a 3. Try again!" }
        5 -> { "Don't cry! You rolled a 5. Try again!" }
        6 -> { "Apologies! You rolled a 6. Try again!" }
        7 -> { "Apologies! You rolled a 7. Try again!" }
        else -> { "Apologies! You rolled a 8. Try again!" }
    }

    println(message)
    println("Your ${myFirstDice.numSides} sided dice rolled ${myFirstDice.roll()}!")

    val mySecondDice = Dice(20)
    println("Your ${mySecondDice.numSides} sided dice rolled ${mySecondDice.roll()}!")



        /**Notar como se reduce el codigo con el for */
    fun calculateFactorialOfANumber(number: Int): Int {
        val factorialList = mutableListOf<Int>()
        for (i in number downTo 1) factorialList.add(i)
//        var counter = number
//        while (counter >= 1) {
//            factorialList.add(counter)
//            counter --
//        }

        return factorialList.reduce { accumulator, nextNumber -> accumulator * nextNumber }
    }


    println(calculateFactorialOfANumber(7))



/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/


    fun validateOlderPerson(ageOfPerson: Int): String {
        return  if (ageOfPerson >= 18) "Esta persona es mayor de edad."
        else "Esta persona no es mayor de edad"
    }

        println(validateOlderPerson(25))



/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/



    fun makeOperation(listOfNumbers: String): Int {
        val range = (1..100)
        return if (listOfNumbers.length > 10){
            range.random() + range.random()
        }else range.random() * range.random()
    }

    println(makeOperation("holatdhgdgdf "))

/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
    /** Varargs allow you to pass any number of arguments by separating them with commas. */
fun printAll(vararg messages: String) {                            // 1
    for (m in messages) print(m)
}

    printAll("something", "more", "Another argument")
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/

    /** Kotlin supports local functions, which are functions inside other functions: */

    fun doSomething(value: String = "Something"){
        fun anotherThing(): Int {
            value.length // We can access the parameters of the "mother" function
            return 5
        }

        val number = anotherThing()

    }



/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/

    /** Functions can have generic parameters, which are specified using angle brackets before the function name: */

    fun <T> singletonList(item: T): List<T> { /*...*/ return listOf()}

/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/

    /** Kotlin also supports tail recursion */

    val eps = 1E-10 // "good enough", could be 10^-15

    tailrec fun findFixPoint(x: Double = 1.0): Double =
        if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))

    /**************************************************************************/
    /* Esto de aca abajo es lo mismo pero la forma tradicional */
    /**************************************************************************/

//    val eps = 1E-10 // "good enough", could be 10^-15
//
//    fun findFixPoint(): Double {
//        var x = 1.0
//        while (true) {
//            val y = Math.cos(x)
//            if (Math.abs(x - y) < eps) return x
//            x = Math.cos(x)
//        }
//    }


/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/

    /** Functions marked with the infix keyword can also be called using the infix notation
     * (omitting the dot and the parentheses for the call). Infix functions must meet the following requirements:

    * 1.They must be member functions or extension functions.

    * 2.They must have a single parameter.

    * 3.The parameter must not accept variable number of arguments and must have no default value.*/

    infix fun Int.shl(x: Int): Int { return 5 }

// calling the function using the infix notation
    1 shl 2

// is the same as
    1.shl(2)

/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/


    val initOrderDemo = InitOrderDemo("Hello")

    WildShape.SOMETHING /*Podemos llamar al companion object sin necesidad de crear la instancia de WildShape*/

    /**
     * Tarea de clases
     * */
    println()
    println("---------------Tarea de clases------------------------------------------------------")
    var smartDevice : SmartDevice = SmartTvDevice("Android TV", "Entertaiment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()



}


class Dice (val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}


/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/

/* -------------------------CLASES-------------------------------*/
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Customer(name: String) {
    val customerKey = name.uppercase()
}
/** Kotlin has a concise syntax for declaring properties and initializing them from the primary constructor: */
//class Person(val firstName: String, val lastName: String, var age: Int)

/** Such declarations can also include default values of the class properties: */
//class Person(val firstName: String, val lastName: String, var isEmployed: Boolean = true)

/** If the constructor has annotations or visibility modifiers,
 *  the constructor keyword is required and the modifiers go before it:*/

//class Customer public @Inject constructor(name: String) { /*...*/ }

/** A class can also declare secondary constructors, which are prefixed with constructor:*/
class Person(val pets: MutableList<Pet> = mutableListOf())

class Pet {
    constructor(owner: Person) {
        owner.pets.add(this) // adds this pet to the list of its owner's pets
    }
}
/** If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor,
 *  either directly or indirectly through another secondary constructor(s).
 *  Delegation to another constructor of the same class is done using the this keyword:*/

class Person2(val name: String) {
    constructor(name: String, parent: Person2) : this(name) {

    }
}

/**
 * Code in initializer blocks effectively becomes part of the primary constructor.
 * Delegation to the primary constructor happens as the first statement of a secondary constructor,
 * so the code in all initializer blocks and property initializers is executed before the body of the secondary constructor.
 * Even if the class has no primary constructor, the delegation still happens implicitly, and the initializer blocks are still executed:
 */

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor $i")
    }
}

/**
 * If a non-abstract class does not declare any constructors (primary or secondary), it will have a generated primary
 * constructor with no arguments. The visibility of the constructor will be public.
 * If you don't want your class to have a public constructor, declare an empty primary constructor with non-default visibility:
 */
class DontCreateMe private constructor() { /*...*/ }


/**
 * Abstract classes﻿
 * A class may be declared abstract, along with some or all of its members.
 * An abstract member does not have an implementation in its class. You don't need to annotate abstract classes or functions with open.
 */
abstract class Polygon {
    abstract fun draw()
}

class Rectangle : Polygon() {
    override fun draw() {
        // draw the rectangle
    }
}

/** You can override a non-abstract open member with an abstract one. */

open class Polygon2 {
    open fun draw() {
        // some default polygon drawing method
    }
}

/**
 * Companion objects
 *
 * If you need to write a function that can be called without having a class instance
 * but that needs access to the internals of a class (such as a factory method),
 * you can write it as a member of an object declaration inside that class.
 * Even more specifically, if you declare a companion object inside your class,
 * you can access its members using only the class name as a qualifier.
 */

abstract class WildShape : Polygon2() {
    companion object {
        const val SOMETHING = 555555
    }
    // Classes that inherit WildShape need to provide their own
    // draw method instead of using the default on Polygon
    abstract override fun draw()
}



enum class Color {
    RED, GREEN, BLUE
}



/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/
/* ---------------------------------------------------------------------------------------------------------*/

data class Persona(
    val name: String,
    val age: Int
)

fun getPeople(): List<Persona> {
    return listOf(Persona("Alice", 29), Persona("Bob", 31))
}

fun comparePeople(): Boolean {
    val p1 = Persona("Alice", 29)
    val p2 = Persona("Alice", 29)
    return p1 == p2  // should be true
}

