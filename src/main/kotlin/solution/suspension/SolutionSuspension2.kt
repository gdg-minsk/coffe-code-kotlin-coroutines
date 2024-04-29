package solution.suspension

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    val i: Int = suspendCoroutine<Int> { cont ->
        cont.resume(19)
    }
    println(i)

    val str: String = suspendCoroutine<String> { cont ->
        cont.resume("educative")
    }
    println(str)

    val b: Boolean = suspendCoroutine<Boolean> { cont ->
        cont.resume(false)
    }
    println(b)
}
