package quiz.job

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * How to fix it? Print and complete
 */
fun main(): Unit = runBlocking {
    launch(Job()) {
        delay(1000)
        println("Will not be printed")
    }
}