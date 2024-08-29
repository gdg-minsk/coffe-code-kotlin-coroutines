package solution.exception

import demo.suspension.MyException
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope

suspend fun main() = supervisorScope {
    val str1 = async<String> {
        throw MyException()
    }

    val str2 = async {
        "Hello World"
    }

    try {
        println(str1.await())
    } catch (e: MyException) {
        println(e)
    }

    println(str2.await())
}