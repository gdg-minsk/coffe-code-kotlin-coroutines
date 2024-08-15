package demo.cancellation

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    val job = launch {
        repeat(15) { i ->
            delay(100)
            println("Printing $i")
        }
    }

    delay(1000)
    job.cancel()
    println("Canceled successfully")
}