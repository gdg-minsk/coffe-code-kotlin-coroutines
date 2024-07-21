package demo.scope

import kotlinx.coroutines.*

suspend fun test(): Int = withTimeout(1500) {
    println("Still thinking ${coroutineContext[Job]}")
    delay(2000)
    println("Still thinking ${coroutineContext[Job]?.isActive}, ${coroutineContext[Job]}")
    delay(2000)
    println("Done! ${coroutineContext[Job]?.isActive},${coroutineContext[Job]}")
    42
}

suspend fun main(): Unit = coroutineScope {
    try {
        val job = launch {
            delay(1000L)
            println("Test")
        }

        job.cancelAndJoin()

    } catch (e: TimeoutCancellationException) {
        println("Cancelled")
    }
    delay(1000) // Extra timeout does not help,
    println("Finished")
}