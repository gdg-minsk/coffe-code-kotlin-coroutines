package demo.scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

class User()

suspend fun fetchUser(): User {
    // Runs forever
    while (true) {
        yield()
    }
}

suspend fun getUserOrNull(): User? =
    withTimeoutOrNull(5000) {
        fetchUser()
    }

suspend fun main(): Unit = coroutineScope {
    val user = getUserOrNull()
    println("User: $user")
}