package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    whenConditions()
}

fun whenConditions() {
    val x = 3
    when (x) {
        1 -> println("x is 1")
        2 -> println("x is 2")
        3 -> println("x is 3")
        else -> println("x is neither 1 nor 2")
    }

    //when as expression and without subject
    val result = when {
        (x > 5) -> println("x is greater than 5")
        else -> println("x less than equal to 5")
    }
    println(result)
}

fun loops() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

}