package org.example.sealed_classes

//Sealed class----------------
sealed class Error {
    object NetworkError : Error()
    object DatabaseError : Error()
    data class CustomError(val message: String) : Error()

}