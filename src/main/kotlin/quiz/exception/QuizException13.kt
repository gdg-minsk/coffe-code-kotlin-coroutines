package quiz.exception

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun main() {
    val topLevelScope = CoroutineScope(Job())

    topLevelScope.launch {
        try {
            coroutineScope {
                launch {
                    throw RuntimeException("RuntimeException in nested coroutine")
                }
            }
        } catch (exception: Exception) {
            println("Handle $exception in try/catch")
        }
    }

    Thread.sleep(100)
}
