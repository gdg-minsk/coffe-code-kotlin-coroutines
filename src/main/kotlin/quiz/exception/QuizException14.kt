package quiz.exception

import demo.suspension.MyException
import demo.suspension.delay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async

suspend fun main() {
    val scope = CoroutineScope(SupervisorJob())

    val job = scope.async {
        val job3 = async {
            throw MyException()
        }
        delay(500L)

        println("A")
    }

    val job2 = scope.async {
        delay(700L)
        println("B")
    }

    job.await()
    println("C")
    job2.await()

    delay(1000L)
    println("D")
}