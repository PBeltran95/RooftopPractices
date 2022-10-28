package functions

/**
* Usando LET: Leer de la consola nombre de clientes hasta que leer la palabra ”Alto”.
* Imprime en pantalla un saludo para cada cliente.
* Si la cadena es vacia, el cliente es nulo.
* Usando WITH: Una tienda tiene un suministro de zapatos, camisas y chaquetas, así como un método para imprimir el inventario.
 * Crea una variable de tipo tienda, actualiza su stock e imprime el inventario.
* Usando RUN: Una Laptop tiene dos funciones, turnOn y turnOff. Para asegurarnos de que funciona como se espera, cada vez que
* tenemos un nuevo objeto portátil, el protocolo consiste en apagarlo y volver a encenderlo. Crea un objeto Laptop e implementa el
* protocolo.
* Usando APPLY: Una cafetería sirve tazas de café. Una taza de café tiene un nombre de cliente y un método para preparar el café. Lee
* un nombre de cliente de la consola, luego llama al método sellCoffee de la cafetería. Crea un objeto taza de café, inicialízalo y sírvelo
* al cliente.
* Usando ALSO: Cada vez que se construye un coche, hay que actualizar los registros de la empresa y notificarlo a la policía.
*Implementar esta funcionalidad en un programa
 */

fun main() {

    var entry = readLine()
    while (entry != "Alto") {
        entry?.let { client ->
            println("Hola nuevo $client")
        }
        entry = readLine()
    }

    with(Store(5,5,1)) {
        showInventory()
    }

    Laptop().run {
        turnOn()
        turnOff()
        turnOn()
    }

    val clientName = readln()
    CoffeeStore().apply {
        this.sellCoffee(clientName)
    }

    Car("Ford", "Fiesta", 1.6, 4,Color.BLACK).also {
        it.company = "TELECOM"
        it.isNotifiedToPolicy = true
    }


}

class Store(val shoes: Int, val shirts: Int, val jackets: Int) {

    fun showInventory() {
        println("Whe have: $shoes shoes, $shirts shirts, $jackets jackets.")
    }
}

class Laptop{

    private var isLaptopOn = true

    fun turnOn() {
        isLaptopOn = true
        println("Laptop now is ON: $isLaptopOn")
    }

    fun turnOff() {
        isLaptopOn = false
        println("Laptop now is Off (isLaptopOn? $isLaptopOn)")
    }
}

/**
* Usando APPLY: Una cafetería sirve tazas de café. Una taza de café tiene un nombre de cliente y un método para preparar el café. Lee
* un nombre de cliente de la consola, luego llama al método sellCoffee de la cafetería. Crea un objeto taza de café, inicialízalo y sírvelo
* al cliente.
 * */

class CoffeeStore {

    fun sellCoffee(clientName: String) {
        CupOfCoffee(clientName).makeCoffee()
    }

    inner class CupOfCoffee(private val clientName: String) {

        fun makeCoffee(){
            println("$clientName your coffee is ready! Come here to get it!")
        }
    }
}

data class Car(
    val brand: String,
    val model: String,
    val engine: Double,
    val sitsNumber: Int,
    val color: Color,
    var company: String? = null,
    var isNotifiedToPolicy: Boolean = false,
)

enum class Color {
    RED,
    BLACK,
    GRAY,
    WHITE,
    GREEN,
}