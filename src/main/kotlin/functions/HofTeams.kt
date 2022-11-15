package functions

/**
 * Ejercicio en equipos:
        * Crear una HOF que tome una lista de clientes y una lambda que retorne una cadena de texto *********
        * A continuación, aplica la expresión lambda a cada nombre de cliente, crea una nueva colección
            de los resultados y devuelve el resultado

        * Crea una expresión lambda que toma un nombre de cliente y devuelve un mensaje personalizado.
        * Llama al HOF e imprime el resultado.
 */

fun main(){
    val listOfClients = mutableListOf<String>()

    println("Bienvenido, escriba algunos nombres: ")
    var name = readLine().toString()

    while (name != "stop"){
        listOfClients.add(name)
        name = readLine().toString()
    }

    println(showClients(listOfClients, { client -> lamda(client) }, { client -> madeCustomMessage(client) }).joinToString("\n") )
    println()
    println("Saliste del programa")
}

fun lamda(client: String): String = "Hola señor $client"

fun madeCustomMessage(client: String): String {
    return when (client){
        "Pablo" -> { "Hola Pablin" }
        "Gabriel" -> { "Todo bien Gabo ?" }
        "Gonza" -> { "Chau Gonza" }
        else -> { "Quien te conoce papá?" }
    }
}


fun showClients(listOfClients: List<String>, lambda: (String) -> String, fallback: (String) -> String): MutableList<String> {
    val newList = mutableListOf<String>()
    listOfClients.forEach { client ->
        newList.add(lambda(client))
        println(fallback(client))
    }
    return newList
}


val madeCustomMessage2 = { client: String -> when(client){
    "Pablo" -> { "Hola Pablin" }
    "Gabriel" -> { "Todo bien Gabo ?" }
    "Gonza" -> { "Chau Gonza" }
    else -> { "Quien te conoce papá?" }
} }

fun doSomething(value: String) {}
fun doSomething(double: Double) {}
fun doSomething(value: Int) {}