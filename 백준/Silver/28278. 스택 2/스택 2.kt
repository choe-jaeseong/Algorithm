import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.Stack
import java.util.StringTokenizer

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var N = br.readLine().toInt()

    var stack = Stack<Int>()
    var sb = StringBuilder()
    for(i in 1..N){
        var st = StringTokenizer(br.readLine())
        var order = st.nextToken().toInt()

        when(order){
            1 -> {
                var num = st.nextToken().toInt()
                stack.push(num)
            }
            2 -> {
                if(stack.isEmpty()) sb.append(-1).append('\n')
                else sb.append(stack.pop()).append('\n')
            }
            3 -> {
                sb.append(stack.size).append('\n')
            }
            4 -> {
                if(stack.isEmpty()) sb.append(1).append('\n')
                else sb.append(0).append('\n')
            }
            5 -> {
                if(stack.isEmpty()) sb.append(-1).append('\n')
                else sb.append(stack.peek()).append('\n')
            }
        }
    }
    print(sb.toString())
}