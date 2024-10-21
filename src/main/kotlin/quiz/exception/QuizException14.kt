@file:Suppress("UNREACHABLE_CODE")

package quiz.exception

import demo.suspension.MyException
import demo.suspension.delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async

suspend fun main() {
    val scope = CoroutineScope(Job())

    val job = scope.async {
        throw MyException()
    }

    val job2 = scope.async {
        delay(100L)
        println("A")
    }

    job.await()
    println("B")
    job2.await()

    delay(500L)
    println("C")
}