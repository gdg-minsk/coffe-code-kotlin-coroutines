package quiz.builders

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Write a code that will provide us with our desired output with a delay of 2 seconds,
 * using the suspending main function together with coroutineScope.
 *
 * Output:
 * Educative !
 * EDUCATIVE!!
 */

suspend fun main() = coroutineScope{
    launch {
        println("Educative!")
        delay(1000)
    }

    println("EDUCATIVE!")
}