import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.*
import kotlin.random.Random

val countAs: Int = 18
val rowsA: Int = 10000000
val arrayOfDigitsAs = ArrayList<Int>()

suspend fun generateFilesAs(count: Int, rows: Int) = coroutineScope {
    for (i in 1..countAs) {
        launch {
            val name = i.toString()
            val fileWriter = FileWriter(name + ".txt")
            val bufferedWriter = BufferedWriter(fileWriter)
            for (i in 1..rows) {
                bufferedWriter.write(Random.nextInt(-10, 10).toString() + "\n")
            }

            println("Файл $i создан")
            bufferedWriter.close()
        }
    }

}

suspend fun deleteFilesAs() = coroutineScope {
    for (i in 1..count) {
        launch {
            val name = i.toString()
            val file = File(name + ".txt")
            if (file.delete()) println("Файл $i удалён")
            else println("Чет не так")
        }
    }
}

suspend fun readDigitsAs() = coroutineScope {
    try {
        for (i in 1..count) {
            launch {
                val fileReader = FileReader("$i.txt");
                val bufferedReader = BufferedReader(fileReader);
                val rows = bufferedReader.lines()
                println("Filename: $i")
                var sum = 0
                rows.forEach { e ->
                    if (e != null) sum += e.toInt()
                }
                bufferedReader.close();
                arrayOfDigits.add(sum)
                println("Sum is: $sum")
            }
        }

    } catch (e: IOException) {
        System.out.println("Ошибка при чтении файла");
        e.printStackTrace();

    }
}

suspend fun main() {
    val time = System.currentTimeMillis()

    generateFilesAs(countAs, rowsA)
    readDigitsAs()
    var sum = 0
    arrayOfDigits.forEach { e -> sum += e }
    println(sum)
    deleteFilesAs()
    println((System.currentTimeMillis() - time).toString() + " millis")

}

