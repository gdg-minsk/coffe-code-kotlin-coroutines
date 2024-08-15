package solution.cancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

suspend fun main(): Unit = coroutineScope {
    val job = launch {
        try {
            repeat(1_000) { i ->
                delay(200)
                println("i = $i")
            }
        } catch (e: CancellationException) {
            println(e)
            throw e
        }
    }
    delay(1500)
    job.cancelAndJoin()
    println("Canceled successfully")
}