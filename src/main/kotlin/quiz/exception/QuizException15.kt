package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

suspend fun main() {
    val scope = CoroutineScope(Job())

    val job = scope.async {
        throw MyException()
    }

    val job2 = scope.async {
        delay(100L)
        println("A")
    }

    try {
        job.await()
    } catch (e: Throwable) {
        println("B")
    }
    job2.await()

    delay(500L)
    println("C")
}