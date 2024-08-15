package quiz.exception

import demo.suspension.MyException
import kotlinx.coroutines.*

suspend fun main() = supervisorScope {
    val str1 = async<String> {
        delay(1000)
        throw MyException()
    }

    val str2 = async {
        delay(2000)
        "A"
    }

    try {
        println(str1.await())
    } catch (e: MyException) {
        println("B")
    }

    println(str2.await())
}
