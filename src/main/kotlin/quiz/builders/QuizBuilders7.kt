package quiz.builders

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        launch {
            val request = launch {
                GlobalScope.launch {
                    delay(1000)
                    println("job1")
                }

                launch {
                    delay(100)
                    println("job2 #1")
                    delay(1000)
                    println("job2 #2")
                }
            }
            delay(500)
            request.cancel() // cancel processing of the request
            delay(1000) // delay a second to see what happens
            println("main")
        }
    }
}
