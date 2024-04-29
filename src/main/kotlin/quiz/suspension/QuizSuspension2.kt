package quiz.suspension

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Write a suspend coroutine that specifies the type of output in its continuation.
 * The output cases should be of three kinds: String, Boolean, and Int.
 *
 * 43
 * educative
 * false
 *
 */

suspend fun main() {
  val result = suspendCoroutine {
      it.resume(43)
  }
    println(result)

    val result2 = suspendCoroutine {
        it.resume("educative")
    }
    println(result2)

    val result3 = suspendCoroutine {
        it.resume(false)
    }
    println(result3)
}
