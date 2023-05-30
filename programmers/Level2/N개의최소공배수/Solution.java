package N개의최소공배수;

public class Solution {

    //최대공약수 (유클리드 호제법)
    public static int gcd(int a, int b){
        int x = Math.max(a,b);
        int y = Math.min(a,b);

        while (x % y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return y;
    }

    public int solution(int[] arr) {
        int answer = arr[0];
        
        //배열의 길이가 1이면 반복x,  그 이상은 다음 인덱스인 1부터 반복.
        for(int i = 1; i < arr.length; i++){
            int gcd = gcd(answer, arr[i]);  //두 값의 최대공약수
            answer = answer * arr[i] / gcd; //두 값의 최대공배수
        }

        return answer;
    }
}

/*
 * 
 */
