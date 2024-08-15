package demo.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        try {
            repeat(20) { i ->
                delay(200)
                println("Printing $i")
            }
        } catch (e: CancellationException) {
            println(e)
            throw e
        } finally {
            println("Will always be printed")
        }
    }
    delay(1000)
    job.cancelAndJoin()
    println("Canceled successfully")
    delay(1000)
}