package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    launch {
        try {
            throw MyException()
        } catch (e: Throwable) {
            println(e)
            println("A")
        }
    }

    println("B")
}


