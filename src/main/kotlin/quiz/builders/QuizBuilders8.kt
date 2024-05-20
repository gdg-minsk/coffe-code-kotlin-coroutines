package quiz.builders

import demo.suspension.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("runBlocking main")

    launch {
        println("job launched")

        runBlocking {
            println("    task1")
            delay(1000)
            println("    task1 complete")
        }

        runBlocking {
            println("    task2")
            delay(1000)
            println("    task2 complete")
        }
    }

    println("Program ends")
}