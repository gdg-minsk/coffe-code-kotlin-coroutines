package quiz.exception

import kotlinx.coroutines.*


fun main() {
    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, exception ->
        println("Handle $exception in CoroutineExceptionHandler")
    }

    val topLevelScope = CoroutineScope(Job())
    topLevelScope.launch {
        try {
            coroutineScope {
                launch {
                    launch {
                        throw RuntimeException("RuntimeException in nested coroutine")
                    }
                }
            }
        } catch (e: Throwable) {
            println("A")
        }
    }

    Thread.sleep(100)
}
