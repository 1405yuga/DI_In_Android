package org.example

interface MyInterface {
    fun foo()
    fun bar() {
        println("bar in MyInterface")
    }

    val prop: Int
    val propWithImp: String
        get() = "Default value"

    fun displayProp(){
        println("Display Prop : $prop")
    }
}

class MyClass : MyInterface {
    override fun foo() {
        println("foo in MyClass")
    }

    override fun bar() {
        println("bar in MyClass")
    }

    override val prop: Int = 42
}