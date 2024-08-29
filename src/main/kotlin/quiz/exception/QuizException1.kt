package quiz.exception

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    try {
        launch {
            delay(100)
            throw Error("Some error")
        }
    } catch (e: Throwable) {
        println("A")
    }

    launch {
        delay(200)
        println("B")
    }
}
