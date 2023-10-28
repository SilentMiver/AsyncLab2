import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import kotlin.random.Random


//
//fun generateFiles(filename: String, insideNumber: Int) {
//    try {
//        val file = File(filename+".txt")
//        if (file.createNewFile()) println("Файл создан")
//        else println("Файлу уже есть")
//    } catch (e: IOException) {
//        println("Ошибка создания файла")
//        e.printStackTrace()
//    }
//
//}

fun generateFiles(count: Int) {
    for (i in 1..count) {
        val name = i.toString()
        val fileWriter = FileWriter(name+".txt")
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(Random.nextInt(-10, 10).toString())
        println("Файл $i создан")
        bufferedWriter.close()


    }

}
fun deleteFiles(count: Int){
    for (i in  1..count){
        val name = i.toString()
        val file = File(name+ ".txt")
        if(file.delete()) println("Файл $i удалён")
        else println("Чет не так")
    }

}
fun main() {
    generateFiles(13)
    println("файлы готовы")
    deleteFiles(13)

}

