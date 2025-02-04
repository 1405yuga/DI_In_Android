package org.example

import org.example.abstract_classes.Dog
import org.example.classes.Person
import org.example.classes.Pet
import org.example.classes.PrivateConstructorClass
import org.example.dataclass.User
import org.example.functional_interface.IntPredicate
import org.example.functional_interface.MyFunctionalInterface
import org.example.inheritance.Mango
import org.example.interfaces.MyClassA
import org.example.sealed_classes.*
import org.example.sealed_classes.Error.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    whenConditions()
    loops()
    classes()
    abstractClass()
    inheritance()
    interfaces()
    functionalInterface()
    extensions()
    dataclasses()
    sealedclasses()
    exceptions(x = 4)
}

fun handleError(error: Error) {
    when (error) {
        is NetworkError -> println("Network issue!")
        is DatabaseError -> println("Database failure!")
        is CustomError -> println("Error: ${error.message}")
        is SomeRandom -> println("Some random error")
    }
}

fun processPayment(payment: Payment) {
    when (payment) {
        CashPayment -> println("Cash payment")
        is CreditCardPayment -> println("Credit card payment")
    }
}

fun sealedclasses() {
    handleError(NetworkError)
    processPayment(CreditCardPayment("1234"))
}

fun dataclasses() {
    val user1 = User("Alice", 23)
    println(user1)
    val user2 = user1.copy(name = "Bob")
    println(user2)
    println("Equality of users : ${user1 == user2}")
    val (name) = user1
    println(name)
}

//property extension
val String.firstCharacter: Char
    get() = this[0]

fun extensions() {
    //function extension
    fun String.addExclamation(): String {
        return "$this!"
    }

    //function extension on custom class
    fun Person.greet() {
        println("Hello, ${this.name}")
    }

    //companion object extension
    fun Dog.Companion.printCompanion() {
        println("Companion object extension")
    }

    val text = "Hello"
    println("Extension function:${text.addExclamation()}")
    println("Property extension: ${text.firstCharacter}")
    val person = Person(name = "Yuga")
    Dog.printCompanion()
    person.greet()
}

fun functionalInterface() {
    val myFunctionalInterface = MyFunctionalInterface { m ->
        println("Printing $m")
    }

    myFunctionalInterface.printMessage("Hello World!")

//    val isEven = IntPredicate { it % 2 == 0 }
    val isEven: IntPredicate = { it % 2 == 0 }
    println(
        "Is 8 even ? - ${isEven(8)}"
    )
}

fun interfaces() {
    val myClass = MyClassA()
    myClass.bar()
    myClass.displayProp()
    myClass.propWithImp
}

fun inheritance() {
    val mango = Mango(name = "Mango", age = 10, type = "Hapus")
}

fun abstractClass() {
    val dog = Dog()
    dog.eat()
    dog.sound()

    //property access------
    println("Property access: ${dog.someText}")
    dog.someText = "World"
    println("Property access: ${dog.someText}")
    println(dog.table)
}

fun classes() {
    val person = Person(name = "Yuga", age = 23)
    val pet = Pet(name = "Kitto")
    val circle = PrivateConstructorClass.createCircle()
    println("Instance created: ${circle.type}")
}

fun exceptions(x: Int) {
//    require(x>4){"Error: Required x > 4"}
//    check(x > 4) { "Error: Required x > 4" }
    val result = try {
//        error("Random error thrown")
        check(x > 4) { "Error: Required x > 4" }
        7
    } catch (ex: Exception) {
        -1
    }
    println("Result after error : $result")
}


fun whenConditions() {
    println("whenConditions--------------")
    val x = 3
    when (x) {
        1 -> println("x is 1")
        2 -> println("x is 2")
        3 -> println("x is 3")
        else -> println("x is neither 1 nor 2")
    }

    //when as expression and without subject
    val result = when {
        (x > 5) -> "x is greater than 5"
        else -> "x less than equal to 5"
    }
    println("result: $result")
}

fun loops() {
    println("Loops--------------")
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    for (i in nums) print(i)
    println()
    for (i in nums.indices) print(nums[i])
    println()
    for (i in 5..nums.lastIndex) print(nums[i])
    println()
    var x = 3
    while (x > 0) {
        print(x)
        x--
    }

    println("Labels---------------------")
    firstLoop@ for (x in 1..10) {
        for (y in 1..10) {
            println("x is $x, y is $y")
            if (x == 1 && y == 3) break@firstLoop
        }
    }
}