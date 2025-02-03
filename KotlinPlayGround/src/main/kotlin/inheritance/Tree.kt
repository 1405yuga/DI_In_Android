package org.example.inheritance

//Base class with primary constructor
//open class Tree(val name: String) {
//    init {
//        println("Tree init name : ${this.name}")
//    }
//}
//
//class Mango(name: String, val type: String) : Tree(name) {
//    init {
//        println("Mango init name : ${this.name}, type : ${this.type}")
//    }
//}

//Base class with secondary constructors
open class Tree {
    constructor(name: String) {
        println("Tree init name : ${name}")
    }

    constructor(name: String, age: Int) {
        println("Tree init age : $age")
    }
}

class Mango : Tree {
    constructor(name: String, age: Int, type: String) : super(name, age) {
        println("Mango init name : ${name}, age: $age, type : ${type}")
    }

}