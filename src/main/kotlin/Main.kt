//suspend fun main() = coroutineScope{
//    val a = async {
//        delay(1000)
//        println("I'm computing part of the answer")
//        6
//    }
//    val b = async {
//        delay(6)
//        println("I'm computing another part of the answer")
//        7
//    }
//    launch {
//        println("Hello!")
//    }
//    println("The answer is ${a.await() * b.await()}")
//}


suspend fun main() {
    val time = System.currentTimeMillis()
    //generateFiles(count, rows)
    println("файлы готовы")
    readDigits()
    var sum = 0
    arrayOfDigits.forEach { e -> sum += e }
    println(sum)
    //deleteFiles()
    val singleThreadTimeResult = (System.currentTimeMillis() - time)
    println((System.currentTimeMillis() - time).toString() + " millis in SingleThread")

    val timeAsync = System.currentTimeMillis()

    //generateFilesAs(countAs, rowsA)
    println(
                "-------------------------------------------------------------- \n" +
                "Starting Async Realisation \n" +
                "-------------------------------------------------------------- "
    )


    readDigitsAs()
    var sumAsync = 0
    arrayOfDigitsAs.forEach { e -> sumAsync += e }
    println(sumAsync)
    //deleteFilesAs()
    println((System.currentTimeMillis() - timeAsync).toString() + " millis")
    val asyncTimeResult = (System.currentTimeMillis() - timeAsync)

    if (sum == sumAsync) println("Ответ верен: $sum == $sumAsync")
    else println("Ответ неверен")

    if (asyncTimeResult <= singleThreadTimeResult) println(
        "Корутины быстрее :)\n " +
                "Single: $singleThreadTimeResult \n Async $asyncTimeResult"
    )
    else println("Корутины не быстрее :(\n Single: $singleThreadTimeResult \n Async $asyncTimeResult")
}