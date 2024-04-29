package demo.suspension

import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class MyException : Throwable("Just an exception")

suspend fun main() {
    try {
        suspendCoroutine<Unit> { cont ->
            cont.resumeWithException(MyException())
        }
    } catch (e: MyException) {
        println("Caught!")
    }
}


suspend fun fetchUser(): User {
    return suspendCoroutine<User> { cont ->
        requestUser { resp ->
            if (resp.isSuccessful) {
                cont.resume(resp.data)
            } else {
                val e = ApiException(
                    resp.code,
                    resp.message
                )
                cont.resumeWithException(e)
            }
        }
    }
}

fun requestUser(block: (Response) -> Unit): Response {
    TODO()
}

data class Response(
    val data: User,
    val code: Int,
    val message: String,
) {
    val isSuccessful: Boolean = TODO()
}

data class User(
    val id: String,
)

class ApiException(val code: Int, override val message: String) : Exception()