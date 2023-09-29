import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var totalPrice = br.readLine().toInt()

    var kinds = br.readLine().toInt()
    var sum = 0
    for(i in 1..kinds) {
        var st = StringTokenizer(br.readLine())
        var price = st.nextToken().toInt()
        var count = st.nextToken().toInt()
        sum += price * count
    }

    var result = if(totalPrice == sum) "Yes" else "No"
    println(result)
}
