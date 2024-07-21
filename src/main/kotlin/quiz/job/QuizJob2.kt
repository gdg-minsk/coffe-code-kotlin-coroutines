package quiz.job

import demo.suspension.delay
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch {
        delay(100L)
        println("Test 1")
    }

    launch {
        launch {
            delay(400L)
            println("Test 3")
        }

        delay(200L)
        println("Test 2")
    }

    val children = coroutineContext[Job]?.children

    val childrenNum = children?.count()
    println("childrenNum: $childrenNum")

    children?.forEach { job -> job.join() }
    println("Done")
}