package demo.flow

import kotlinx.coroutines.flow.flow

val flow2 = flow {
    emit("Message1")
    throw MyError()
}

suspend fun main(): Unit {
    try {
        flow2.collect { println("Collected $it") }
    } catch (e: MyError) {
        println("Caught")
    }
}