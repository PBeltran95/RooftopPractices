package collections

fun main(){
    val cadenaDeNumeros = arrayOf(10,50,60,88,96,15,5,1,34,44)
    val buscado = 5

//    println("Encontraste el numero $buscado ? ${buscarNumeroEnCadena(cadenaDeNumeros, buscado)}")
//
//    cadenaDeNumeros.forEach { numero ->
//        if (numero == buscado) {
//            println("Encontre el numero")
//            return
//        }
//    }
}

fun buscarNumeroEnCadena(cadena: Array<Int>, numeroBuscado: Int): Boolean {
    var encontrado = false
    var indice = 0
    while (!encontrado && indice < cadena.size){
        if (numeroBuscado == cadena[indice]){
            encontrado = true
        }
        indice++
    }
    return encontrado
}