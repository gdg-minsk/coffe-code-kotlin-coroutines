package solution.context

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() {
    val ctx1: CoroutineContext = CoroutineName("Hello World")
    println(ctx1[CoroutineName]?.name) // Hello World

    val ctx2: CoroutineContext = CoroutineName("Inc.")
    println(ctx2[CoroutineName]?.name) // Inc.

    val ctx3 = ctx1 + ctx2
    println(ctx3[CoroutineName]?.name) // Inc.
}