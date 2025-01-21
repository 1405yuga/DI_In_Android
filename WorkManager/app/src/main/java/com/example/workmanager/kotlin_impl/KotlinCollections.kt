package com.example.workmanager.kotlin_impl

fun main() {
    println("Hello!")

    val numbers = listOf(1, 2, 3, 4, 5, 6, 10, 8, 3)

    //Search-------------------------
    val firstEven = numbers.find { it % 2 == 0 }
    val lastEven = numbers.findLast { it % 2 == 0 }
    println("firstEven : $firstEven, lastEven: $lastEven ")

    //Transform-----------------------
    val allSquared = numbers.map { it * it }
    val indexed = numbers.mapIndexed { index, value -> index * value }
    val indexedNotNull = numbers.mapIndexedNotNull { index, i ->
        if (i % 2 == 0) "Even at $index" else null
    }
    println("allSquared : $allSquared")
    println("indexed : $indexed")
    println("indexedNotNull : $indexedNotNull")

    //Filtering----------------------------
    val takeFirstFourElements = numbers.take(4)
    val takeUnlessCondition = numbers.takeUnless { it.contains(5) } //it is collection , if true -> returns null
    println("getFirstFourElements : $takeFirstFourElements")
    println("takeUnlessCondition : $takeUnlessCondition")

}
