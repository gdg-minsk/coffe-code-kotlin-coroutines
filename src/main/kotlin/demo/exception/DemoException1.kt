package demo.exception

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
            delay(500)
            throw Error("Some error")
        }

        launch {
            delay(1000)
            println("Will be printed")
        }
    }

    // when will be printed done?
    delay(1000)
    println("Done")
}