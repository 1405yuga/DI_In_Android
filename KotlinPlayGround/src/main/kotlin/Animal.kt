package org.example

open class WildCreatures{
    open fun sound(){
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
    override fun sound() {
        println("Dog barks!!")
    }

}