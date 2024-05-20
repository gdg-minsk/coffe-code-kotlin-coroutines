package quiz.builders

import demo.suspension.delay
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            launch {
                println("C")
            }
            coroutineScope {
                launch {
                    delay(500)
                    println("D")
                }

                delay(100)
                println("E")
            }

            println("F")
        }
        println("B")
    }

    println("A")
}
