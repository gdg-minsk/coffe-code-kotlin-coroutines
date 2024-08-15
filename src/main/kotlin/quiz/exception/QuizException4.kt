package quiz.exception

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
            launch {
                delay(500L)
                throw Error("Some error")
            }

            delay(700L)
            println("A")
        }

        launch {
            delay(1000)
            println("B")
        }
    }

    delay(1000)
    println("C")
}
