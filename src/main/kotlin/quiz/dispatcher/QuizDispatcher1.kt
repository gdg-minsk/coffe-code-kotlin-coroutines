package quiz.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
Write a program using dispatchers to correct the shared state problem. A variable
i has to be incremented from 10,000 threads, and it should not be shared with any threads.
Print the value of i after two seconds of delay. Use dispatcher in such
a way that the shared state problem is resolved.

The output will be shown after two seconds of delay.
10000
 */

suspend fun main(): Unit = coroutineScope {

}