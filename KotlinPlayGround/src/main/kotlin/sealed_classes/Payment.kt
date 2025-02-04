package org.example.sealed_classes

//sealed interface--------------
sealed interface Payment

data class CreditCardPayment(val number: String) : Payment
object CashPayment : Payment