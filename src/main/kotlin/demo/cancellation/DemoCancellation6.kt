package demo.cancellation

import kotlinx.coroutines.*
import kotlin.coroutines.cancellation.CancellationException

suspend fun main(): Unit = coroutineScope {
    var childJob: Job? = null
    val job = launch {
        launch {
            try {
                delay(1000)
                println("A")
            } finally {
                println("A finished")
            }
        }
        childJob = launch {
            try {
                delay(2000)
                println("B")
            } catch (e: CancellationException) {
                println("B cancelled")
            }
        }
        launch {
            delay(3000)
            println("C")
        }.invokeOnCompletion {
            println("C finished")
        }
    }
    delay(100)
    job.cancelAndJoin()
    println("Cancelled successfully")
    println(childJob?.isCancelled)
}
