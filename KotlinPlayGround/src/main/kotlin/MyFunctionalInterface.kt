package org.example

fun interface MyFunctionalInterface {
    fun printMessage(message: String) //only one abstract method
    fun someImplementedMethods() {
        println("SomeImplementedMethods")
    }

    fun someOtherImplementedMethods() {
        println("SomeOtherImplementedMethods")
    }
}