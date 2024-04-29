package quiz.builders

import demo.suspension.delay
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            launch {
                println("1")
            }
            coroutineScope {
                launch {
                    delay(500)
                    println("2")
                }

                delay(100)
                println("3")
            }

            println("4")
        }
    }
}
