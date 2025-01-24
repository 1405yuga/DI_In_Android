package org.example

abstract class Animal {
    fun eat() {
        println("Eating !")
    }

    abstract fun sound()
}

class Dog : Animal() {
    override fun sound() {
        println("Dog barks!!")
    }

}