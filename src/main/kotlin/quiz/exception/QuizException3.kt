package quiz.exception

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    withContext(SupervisorJob()) {
        launch {
            delay(100)
            throw Error("Some error")
        }
        launch {
            delay(200)
            println("A")
        }
        launch {
            delay(200)
            println("B")
        }
    }
    delay(100)
    println("C")
}
