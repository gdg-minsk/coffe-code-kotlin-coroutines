@file:Suppress("UNREACHABLE_CODE")

package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

suspend fun main() {
    val scope = CoroutineScope(SupervisorJob())

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