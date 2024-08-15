package demo.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        delay(1000)
        println("Not printed")
    }
    job.invokeOnCompletion { e: Throwable? ->
        println("Finished, exception: $e")
    }
    delay(400)
    job.cancelAndJoin()
}