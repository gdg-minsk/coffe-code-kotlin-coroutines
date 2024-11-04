package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.*

suspend fun main() {
    val scope = CoroutineScope(Job())
    val job = scope.async {
        async {
            throw MyException()
        }
        delay(50L)
        println("A")
    }

    val job2 = scope.async {
        delay(100L)
        println("B")
    }

    try {
        job.await()
    } catch (e: Throwable) {
        println("C")
    }
    job2.await()
    delay(300L)
    println("D")
}