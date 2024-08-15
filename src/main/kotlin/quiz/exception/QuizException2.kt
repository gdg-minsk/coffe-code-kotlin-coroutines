package quiz.exception

import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Suppress("warnings")
fun main(): Unit = runBlocking {
    launch(SupervisorJob()) {
        launch {
            delay(1000)
            throw Error("Some error")
            println("A")
        }

        launch {
            delay(2000)
            println("B")
        }
    }

    delay(3000)
    println("C")
}
