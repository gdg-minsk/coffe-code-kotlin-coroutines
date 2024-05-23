package quiz.context

import kotlinx.coroutines.CoroutineName

/**
 * Write a code that involves creating two elements with names “Hello World” and “Inc.”
 * using the CoroutineName class. When we add another element with the same key,
 * the new element replaces the previous one, and the output will be “Inc.”
 *
 * Output:
 * Hello World
 * Inc.
 * Inc.
 */
fun main () {
    //write your code here
    val ctx = CoroutineName("Hello World")
    val ctx1 = CoroutineName("Inc.")

    println(ctx[CoroutineName]?.name)
    println(ctx1[CoroutineName]?.name)

    val ctx3 = ctx + ctx1

    println(ctx3[CoroutineName]?.name)
}