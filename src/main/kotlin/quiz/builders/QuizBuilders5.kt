package quiz.builders

import demo.suspension.delay
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            launch {
                println("A")
            }
            coroutineScope {
                launch {
                    delay(500)
                    println("B")
                }

                delay(100)
                println("C")
            }
            println("D")
        }
        println("E")
    }

    println("F")
}
