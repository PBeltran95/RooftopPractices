import java.lang.Math.abs

//fun main(args: Array<String>) {
//
//    val animals = arrayListOf("leon", "cebra", "mono", "elefante")
//    animals.add("panda")
//    println(animals)
//    animals.remove("leon")
//    println("Hay elefantes o jirafas ? ${animals.contains("elefante") || animals.contains("jirafa")}")
//    println(animals)
//}
lateinit var algo: String

fun main() {

    val fruitsBag = listOf("apple","orange","banana","grapes")  // 1
    val clothesBag = listOf("shirts","pants","jeans")           // 2
    val cart = listOf(fruitsBag, clothesBag)                    // 3
    val mapBag = cart.map { it }                                // 4
    val flatMapBag = cart.flatMap { it }                        // 5

    println("Your bags are: $mapBag")
    println("The things you bought are: $flatMapBag")

    val shuffled = listOf(5, 4, 2, 1, 3, -10)                   // 1
    val natural = shuffled.sorted()                             // 2
    val inverted = shuffled.sortedBy { -it }                    // 3
    val descending = shuffled.sortedDescending()                // 4
    val descendingBy = shuffled.sortedByDescending { abs(it)  }

    println("Inverted natural order of absolute values: $descendingBy")

    ::algo.isInitialized
}

