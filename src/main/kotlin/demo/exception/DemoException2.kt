package demo.exception

import kotlinx.coroutines.*

suspend fun main() = runBlocking {
    val topLevelScope = CoroutineScope(SupervisorJob())

    topLevelScope.async {
        throw RuntimeException("RuntimeException in async coroutine")
    }

    delay(1000L)
}