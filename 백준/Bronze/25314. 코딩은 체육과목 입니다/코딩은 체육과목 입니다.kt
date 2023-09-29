import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var N = br.readLine().toInt()

    var result = ""
    for(i in 1..N/4)
        result += "long "
    if(N%4!=0) result += "long "
    result += "int"

    print(result)
}