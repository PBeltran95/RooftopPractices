package functions

/**
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-function-types-and-lambda#2
 */
fun main(){

    // val trickFunction = trick
    //trick()
    //trickFunction()
    //treat()

    val coins: (Int) -> String = {
        "$it quarters"
    }


    val cupcake: (Int) -> String = { quantity ->
        "Have a cupcake!"
    }


    //val treatFunction = trickOrTreat(false) { quantity -> coins.invoke(quantity) }
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, cupcake)
    val trickFunctionTwo = trickOrTreat(true, null)
    repeat(4) {
        treatFunction()
    }
    trickFunction()
    trickFunctionTwo()
}



fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}



/**
 * https://play.kotlinlang.org/koans/Introduction/Lambdas/Task.kt
 */
fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { number -> number % 2 == 0 }