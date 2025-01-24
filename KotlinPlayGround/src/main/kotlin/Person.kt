package org.example

//secondary constructor with primary constructor
class Person(val name: String) {
    init {
        println("Person init block")
    }

    constructor(name: String, age: Int) : this(name) {
        println("Secondary constructor Person : ${this.name} - $age") //here age is not member property
    }
}

//secondary constructor without primary constructor
class Pet {
    //declare member variables
    var name: String
    var age: Int

    init {
        println("Pet init block")
    }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
        println("Secondary constructor Pet : ${this.name} - $age")
    }

    constructor(name: String) {
        this.name = name
        this.age = 0
        println("Secondary constructor Pet : ${this.name} - $age")
    }
}