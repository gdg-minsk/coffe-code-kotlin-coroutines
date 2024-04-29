package demo.suspension

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")
    val user = suspendCoroutine<User> { cont ->
        requestUser { user ->
//            cont.resume(user)
        }
    }
    println(user)
    println("After")
}