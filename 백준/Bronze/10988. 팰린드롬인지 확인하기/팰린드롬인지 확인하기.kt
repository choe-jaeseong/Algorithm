import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var str = br.readLine()

    var result = if(isPalindrom(str)) 1 else 0
    println(result)
}

fun isPalindrom(str: String): Boolean {
    var lp = 0
    var rp = str.length-1
    while(lp < rp){
        if(str.get(lp) != str.get(rp)) return false
        lp++
        rp--
    }
    return true
}
