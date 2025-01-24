package org.example

//Base class with primary constructor
open class Tree(val name: String) {
    init {
        println("Tree init name : ${this.name}")
    }
}

class Mango(name: String, val type: String) : Tree(name) {
    init {
        println("Mango init name : ${this.name}, type : ${this.type}")
    }
}