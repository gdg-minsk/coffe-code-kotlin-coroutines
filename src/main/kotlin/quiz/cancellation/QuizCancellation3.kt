package quiz.cancellation

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class UserNotFoundException1 : CancellationException()

suspend fun main() {
    try {
        updateUserData1()
    } catch (e: UserNotFoundException1) {
        println("A")
    }
}

suspend fun updateUserData1() = coroutineScope {
    launch { updateUser1() }
    launch { updateTweets1() }
}

suspend fun updateTweets1() {
    delay(1000)
    println("B")
}

suspend fun updateUser1() {
    throw UserNotFoundException1()
}