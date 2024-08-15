package demo.cancellation

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        repeat(20) { i ->
            Thread.sleep(200)
            yield()
            println("Printing $i")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Canceled successfully")
    delay(1000)
}