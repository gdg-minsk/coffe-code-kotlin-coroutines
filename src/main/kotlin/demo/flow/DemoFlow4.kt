package demo.flow

import kotlinx.coroutines.flow.flow

suspend fun main() {
    flow { // 1
        emit("A")
        emit("B")
        emit("C")
    }.collect { value -> // 2
        println(value)
    }
}