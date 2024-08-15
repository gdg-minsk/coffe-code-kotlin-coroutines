package quiz.cancellation

import kotlinx.coroutines.delay
import kotlin.coroutines.cancellation.CancellationException

class UserNotFoundException : CancellationException()

suspend fun main() {
    try {
        updateUserData()
    } catch (e: UserNotFoundException) {
        println("A")
    }
}

suspend fun updateUserData() {
    updateUser()
    updateTweets()
}

suspend fun updateTweets() {
    delay(1000)
    println("B")
}

suspend fun updateUser() {
    throw UserNotFoundException()
}