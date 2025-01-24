package org.example

open class WildCreatures {
    open fun sound() {
        println("Roarrrrrrrrr")
    }
}

abstract class Animal : WildCreatures() {
    fun eat() {
        println("Eating !")
    }

    abstract override fun sound()
}

class Dog : Animal() {
    var someText: String = ""
        get() = "Hi, $field"
        set(value) {
            field = "Hello $value"
        }

    override fun sound() {
        println("Dog barks!!")
    }

}