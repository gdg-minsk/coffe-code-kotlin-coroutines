package demo.exception

import kotlinx.coroutines.*

suspend fun main() {
    val scope = CoroutineScope(SupervisorJob())

    val deferredResult = scope.async {
        throw RuntimeException("RuntimeException in async coroutine")
    }

    val job = scope.launch {
        try {
            deferredResult.await()
        } catch (exception: Exception) {
            println("Handle $exception in try/catch")
        }
    }

    println(job)

    delay(1000L)
}