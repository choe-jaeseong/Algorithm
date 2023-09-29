import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var answer = 0L
    while(st.hasMoreTokens()){
        answer += st.nextToken().toLong()
    }
    print(answer)

}