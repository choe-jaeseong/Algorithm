public class Main {
    static boolean[] visited = new boolean[10001];
    public static void main(String[] args) {
        //1부터 9999까지 d(n) 체크
        for(int i=1; i<10000; i++) {
            int tmp = i;
            while(tmp < 10000) {
                int sum = tmp;

                while(tmp > 0) {
                    sum += (tmp % 10);
                    tmp /= 10;
                }

                if(sum > 10000) break;
                else visited[sum] = true;

                tmp = sum;
            }
        }

        //체크 안 된 숫자 출력 (개행)
        for(int i=1; i<visited.length; i++) {
            if(visited[i] == false)
                System.out.println(i);
        }
    }
}
