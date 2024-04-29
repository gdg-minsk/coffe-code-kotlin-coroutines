package demo.builders

import kotlinx.coroutines.*

//fun main() {
//    GlobalScope.launch {
//        delay(1000L)
//        println("World 1!")
//    }
//    GlobalScope.launch {
//        delay(1000L)
//        println("World 2!")
//    }
//    println("Hello,")
//    Thread.sleep(2000L)
//}

fun main2() {
    runBlocking {
        delay(1000L)
        println("World 1!")
    }
    runBlocking {
        delay(1000L)
        println("World 2!")
    }
    println("Hello,")
}

fun main3() {
    Thread.sleep(1000L)
    println("World 1!")
    Thread.sleep(1000L)
    println("World 2!")
    Thread.sleep(1000L)
    println("World 3!")
    println("Hello,")
}

fun main4() = runBlocking {
    val resultDeferred: Deferred<Int> = GlobalScope.async {
        delay(1000L)
        42
    }
    // do other stuff...
    val result: Int = resultDeferred.await() // (1 sec)
    println(result) // 42
    // or just
    println(resultDeferred.await()) // 42
}

fun main() = runBlocking {
    val res1 = GlobalScope.async {
        delay(1000L)
        "Text 1"
    }
    val res2 = GlobalScope.async {
        delay(3000L)
        "Text 2"
    }
    val res3 = GlobalScope.async {
        delay(2000L)
        "Text 3"
    }
    println(res2.await())
    println(res1.await())
    println(res3.await())
    coroutineScope {  }
}



