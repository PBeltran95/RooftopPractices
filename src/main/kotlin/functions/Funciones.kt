package functions

fun main(){

    /**Notar como se reduce el codigo con el for */
    fun calculateFactorialOfANumber(number: Int): Int {
        val factorialList = mutableListOf<Int>()
        for (i in number downTo 1) factorialList.add(i)

        return factorialList.reduce { accumulator, nextNumber -> accumulator * nextNumber }
    }

}