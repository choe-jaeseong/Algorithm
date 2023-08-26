import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int now = 100, count = 0, target;
    private static int[] remote = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if(n > 0){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) remote[Integer.parseInt(st.nextToken())] = 1;
        }
        
        if(target == now) {
            System.out.println(0);
            return;
        }

        count = Math.abs(target - now);
        //리모컨이 가리킬 수 있는 숫자를 전체 탐색
        for(int i=0; i<=999999; i++){
            String s = String.valueOf(i);
            boolean flag = false;
            for(int j=0; j<s.length(); j++){
                if(remote[s.charAt(j)-'0'] == 1){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;

            //누를 수 있는 숫자라면
            int min = s.length() + Math.abs(target - i);
            count = count > min ? min : count;
        }

        //now 가 결정된 상태
        System.out.println(count);
    }
}

/*

1. 0 ~ 9 버튼이 있다. remote 값이 0인 것은 가능한 버튼이다.
2. 현재 가능한 버튼으로 target과 가장 가까운 숫자를 찾는다.
3. count += now 숫자 길이
4. count += target과 now 차이

 */