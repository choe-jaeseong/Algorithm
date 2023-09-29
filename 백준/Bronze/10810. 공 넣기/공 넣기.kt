import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()

    var arr = Array(N, {0})
    for(i in 1..M) {
        st = StringTokenizer(br.readLine())
        var j = st.nextToken().toInt()
        var k = st.nextToken().toInt()
        var num = st.nextToken().toInt()
        fill(arr, j, k, num)
    }

    for(i in arr.indices){
        print("${arr[i]} ")
    }
}

fun fill(arr: Array<Int>, j: Int, k: Int, num: Int) {
    for(i in j..k){
        arr[i-1] = num
    }
}

