import kotlinx.coroutines.*

suspend fun main() = coroutineScope{
    val a = async {
        delay(1000)
        println("I'm computing part of the answer")
        6
    }
    val b = async {
        delay(6)
        println("I'm computing another part of the answer")
        7
    }
    launch {
        println("Hello!")
    }
    println("The answer is ${a.await() * b.await()}")
}