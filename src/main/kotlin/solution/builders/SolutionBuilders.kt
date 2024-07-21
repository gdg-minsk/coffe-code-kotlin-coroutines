package solution.builders

import demo.suspension.delay
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Write a code that will provide us with our desired output with a delay of 2 seconds,
 * using the suspending main function together with coroutineScope.
 *
 * Output:
 * Educative !
 * EDUCATIVE!!
 */

suspend fun main(): Unit = coroutineScope {
    launch {
        delay(2000L)
        println("EDUCATIVE!!")
    }
    println("Educative !")
}