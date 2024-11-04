package demo.flow

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

suspend fun present(place: String, message: String) {
    val ctx = coroutineContext
    val name = ctx[CoroutineName]?.name
    println("[$name] $message on $place")
}

val flow8 = flow {
    present("flow builder", "Message")
    emit("Message")
}

suspend fun main(): Unit {
    withContext(CoroutineName("Name1")) {
        flow8
            .flowOn(CoroutineName("Name2"))
            .onEach { present("onEach", it) }
            .flowOn(CoroutineName("Name3"))
            .collect { present("collect", it) }
    }
}