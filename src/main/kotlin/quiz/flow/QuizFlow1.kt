package quiz.flow

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext

/**
 * Write a program where you will try to complete the code by starting a coroutine. The coroutine will keep processing
 * three times with a delay of 0.1 seconds, and when the coroutines end, it will print the name of users
 * with a delay of 1 second. You have to make a suspending function named getFlow using Flow,
 * and this function will print the user’s count.
 *
 * Output:
 * Coroutine Processing
 * Coroutine Processing
 * Coroutine Processing
 * User0
 * User1
 * User2
 */
suspend fun main() {
    withContext(newSingleThreadContext("main")) {
        // launch a coroutine

//        val list = getFlow()
//        list.collect { println(it) }
    }
}