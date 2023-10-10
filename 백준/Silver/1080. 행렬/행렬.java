import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r][c];
        int[][] target = new int[r][c];

        //원래 배열 : arr
        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<c; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        //타겟 배열 : target
        for (int i = 0; i < r; i++) {
            String[] str = br.readLine().split("");
            for(int j=0; j<c; j++){
                target[i][j] = Integer.parseInt(str[j]);
            }
        }
        //바꾸기 시작
        int count = 0;
        for(int i=0; i<r-2; i++){
            for(int j=0; j<c-2; j++){
                if(arr[i][j] != target[i][j]){
                    reverseArr(arr, i, j);
                    count++;
                }
            }
        }
        //결과 출력
        if(isSameArr(arr, target)){
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean isSameArr(int[][] arr, int[][] target) {
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

    private static void reverseArr(int[][] arr, int x, int y) {
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                arr[i][j] = arr[i][j] == 1 ? 0 : 1;
            }
        }
    }
}
