package demo.flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList

val flow9 = flow {
    while (true) {
        emit("Message")
    }
}

suspend fun main(): Unit {
    flow9.toList()

    for (i in 0..9) {
        println("Print i:$i")
    }
}