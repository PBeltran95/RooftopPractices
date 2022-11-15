package functions

fun main(){
    val countryList = listOf("Argentina", "Mexico", "Polonia", "Arabia Saudita")
    showCountries(countryList) { doSomething() }
}

fun showCountries(countryList: List<String>, callback: (String) -> Unit){
    countryList.forEach { country ->

    }
}

fun doSomething() {}