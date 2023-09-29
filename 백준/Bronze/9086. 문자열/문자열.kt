import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var N = br.readLine().toInt()
    for(i in 1..N){
        var str = br.readLine()
        print(str.get(0))
        print(str.get(str.length-1))
        println()
    }
}