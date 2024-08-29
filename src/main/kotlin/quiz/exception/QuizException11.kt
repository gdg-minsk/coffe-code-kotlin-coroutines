package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.*

suspend fun main() {
    val scope = CoroutineScope(SupervisorJob())

    scope.launch {
        val job = async {
            throw MyException()
        }

        try {
            job.await()
        } catch (e: Throwable) {
            println("A")
        }

        println("B")
    }

    delay(1000L)
    println("C")
}
