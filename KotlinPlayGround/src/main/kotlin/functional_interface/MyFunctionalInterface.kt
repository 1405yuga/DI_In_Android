package org.example.functional_interface

fun interface MyFunctionalInterface {
    fun printMessage(message: String) //only one abstract method
    fun someImplementedMethods() {
        println("SomeImplementedMethods")
    }

    fun someOtherImplementedMethods() {
        println("SomeOtherImplementedMethods")
    }
}

//fun interface IntPredicate{
//    fun accept(i: Int): Boolean
//}
//converted into typealias , since only one method is present
typealias IntPredicate = (Int) -> Boolean