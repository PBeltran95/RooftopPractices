class Auto(val marca: String, val modelo: String){

    //Header
    private var _transmision: String? = null
    var transmission: String?
            get() = _transmision
            set(a) { _transmision = a }

    companion object {
        @JvmStatic
        val TAG = "Auto"

        @JvmStatic
        fun frenarAllCarros(){}
    }
    //Body
    fun arrancar(conductor: String, hasLlave: Boolean): Boolean { return true }

    fun frenar():Boolean { return true }

}

data class Color2(val color: String) {

}