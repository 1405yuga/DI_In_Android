package org.example

interface MyInterface {
    fun foo()
    fun bar() {
        println("bar in MyInterface")
    }
}

class MyClass : MyInterface {
    override fun foo() {
        println("foo in MyClass")
    }

    override fun bar() {
        println("bar in MyClass")
    }
}