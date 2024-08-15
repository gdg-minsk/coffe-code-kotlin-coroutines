package demo.cancellation

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        try {
            delay(200)
            println("Coroutine finished")
        } finally {
            println("Finally")
            withContext(NonCancellable) {
                delay(1000L)
                println("Cleanup done")
            }
        }
    }
    delay(100)
    job.cancelAndJoin()
    println("Done")
}