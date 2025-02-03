package org.example.interfaces

interface MyInterfaceA {
    fun foo()
    fun bar() {
        println("bar in MyInterfaceA")
    }

    val prop: Int
    val propWithImp: String
        get() = "Default value"

    fun displayProp() {
        println("Display Prop : $prop")
    }
}

interface MyInterfaceB {
    fun foo() {
        println("foo in MyInterfaceB")
    }

    fun bar() {
        println("bar in MyInterfaceB")
    }
}

class MyClassA : MyInterfaceA, MyInterfaceB {
    override fun foo() {
        println("foo in MyClass")
    }

    override fun bar() {
        println("bar in MyClass")
        super<MyInterfaceB>.bar()
        super<MyInterfaceA>.bar()
    }

    override val prop: Int = 42
}