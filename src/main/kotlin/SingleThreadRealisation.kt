import java.io.*
import kotlin.collections.ArrayList
import kotlin.random.Random

val count: Int = 18
val rows: Int = 1000000
val arrayOfDigits = ArrayList<Int>()
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

fun generateFiles(count: Int, rows: Int) {
    for (i in 1..count) {
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

fun deleteFiles() {
    for (i in 1..count) {
        val name = i.toString()
        val file = File(name + ".txt")
        if (file.delete()) println("Файл $i удалён")
        else println("Чет не так")
    }


}

fun readDigits() {
    try {
        for (i in 1..count) {
            val fileReader = FileReader("$i.txt");
            val bufferedReader = BufferedReader(fileReader);
            val rows = bufferedReader.lines()
            println("Filename: $i")
            var sum = 0
            rows.forEach { e ->
                if (e != null) sum+= e.toInt()
             }
            bufferedReader.close();
            arrayOfDigits.add(sum)
            println("Sum is: $sum")
        }

    } catch (e: IOException) {
        System.out.println("Ошибка при чтении файла");
        e.printStackTrace();

    }
}



fun main() {


    generateFiles(count, rows)
    println("файлы готовы")
    readDigits()
    var sum = 0
    arrayOfDigits.forEach { e -> sum += e }
    println(sum)
    deleteFiles()




}

