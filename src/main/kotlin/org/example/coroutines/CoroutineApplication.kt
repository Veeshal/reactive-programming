package org.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

fun main() = runBlocking {

    val scope = CoroutineScope(Job() + Dispatchers.Unconfined)
    val job = scope.launch {
        collectNumber()
    }

    job.join()
}

suspend fun collectNumber() {
    flowOf(55, 65, 20, 5)
        .map { "Thread ${Thread.currentThread().name} => $coroutineContext <= Input: $it" }
        .flowOn(CoroutineName("Vishal"))
        .collect {
            println(it)
        }
}