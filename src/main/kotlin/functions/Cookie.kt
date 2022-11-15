package functions

/**
 * https://developer.android.com/codelabs/basic-android-kotlin-compose-higher-order-functions#1
 */

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)


fun main() {
    cookies.forEach {
        println("Menu item ${it.name}")
    }

    println("-----------------------------------------------------------------------")

    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    fullMenu.forEach {
        println(it)
    }


    println("-----------------------------------------------------------------------")

    val softBakedMenu = cookies.filter {
        it.softBaked
    }

    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    println("-----------------------------------------------------------------------")

    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenuGrouping = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies: \n")
    softBakedMenuGrouping.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:\n")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }


    println("-----------------------------------------------------------------------")

    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total price: $${totalPrice}")

    /**
     * La funcion fold() toma un parametro como inicial, no confundirla con la funcion reduce(),
     * que toma como parametro inicial el primer valor de la coleccion y tambien suma los valores
     * de la misma a fin de obtener un valor total.
     */




    println("-----------------------------------------------------------------------")


    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println("Alphabetical menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}


val cookies = listOf(
    Cookie(
        name = "Chocolate chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)