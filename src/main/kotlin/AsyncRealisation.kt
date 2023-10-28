import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import kotlin.random.Random


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

suspend fun main() {

    generateFilesAs(countAs,rowsA)
    deleteFilesAs()

}

val countAs: Int = 18
val rowsA: Int = 10000000
val arrayOfDigitsAs = ArrayList<Int>()