fun main() {

}

//fun Shop.getSetOfCustomers(): Set<Customer> =
//    this.customers.toSet()

//fun Shop.getCustomersSortedByOrders(): List<Customer> =
//    this.customers.sortedByDescending { it.orders.size }

// Find all the different cities the customers are from

//fun Shop.getCustomerCities(): Set<City> =
//    customers.map { it.city }.toSet()
//
//// Find the customers living in a given city
//fun Shop.getCustomersFrom(city: City): List<Customer> =
//    customers.filter { it.city == city }

//fun Customer.getOrderedProducts(): List<Product> =
//    orders.flatMap(Order::products)

//fun Shop.getOrderedProducts(): Set<Product> =
//    customers.flatMap(Customer::getOrderedProducts).toSet()

data class Shop(
    val customers: List<Customer>,
    val orders: List<Customer>
)