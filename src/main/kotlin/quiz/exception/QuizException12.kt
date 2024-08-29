package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.*

suspend fun main() {
    val scope = CoroutineScope(Job())

    scope.launch {
        async {
            throw MyException()
        }
    }

    delay(1000L)
    println("A")
}


