package demo.exception

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

suspend fun main() {
    val scope = CoroutineScope(Job())

    val deferredResult = scope.async {
        throw RuntimeException("RuntimeException in async coroutine")
    }

    try {
        deferredResult.await()
    } catch (exception: Exception) {
        println("Handle $exception in try/catch")
    }

    delay(1000L)
}