package org.example.abstract_classes

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
    companion object {
        //some companion object
    }

    //using backing field
    var someText: String = ""
        get() = "Hi, $field"
        set(value) {
            field = "Hello $value"
        }

    //using backing property
    private var _table: Map<String, Int>? = null
    val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

    override fun sound() {
        println("Dog barks!!")
    }

}