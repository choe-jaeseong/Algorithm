package Level1.K번째수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i]=list.get(commands[i][2]-1);
        }
        return answer;
    }

    //다른 풀이1
    public int[] solution1(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
    //다른 풀이2
    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a = 0;
        for(int[] info : commands){
            int i = info[0];
            int j = info[1];
            int k = info[2];

            int[] buf = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(buf);
            answer[a] = buf[k-1];
            a++;
        }

        return answer;
    }
    //다른 풀이3  (퀵정렬)
    public int[] solution3(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
    }

    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
}
