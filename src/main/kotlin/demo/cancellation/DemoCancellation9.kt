package demo.cancellation

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        do {
            Thread.sleep(200)
            println("Printing")
        } while (isActive)
    }
    delay(1000)
    job.cancelAndJoin()
    println("Canceled successfully")
}