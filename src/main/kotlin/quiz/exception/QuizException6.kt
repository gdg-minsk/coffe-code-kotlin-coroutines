package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

suspend fun main() = coroutineScope {
    val deferred = async {
        throw MyException()
    }

    try {
        deferred.await()
    } catch (e: Exception) {
        println("A")
    }

    println("B")
}


