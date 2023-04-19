package 고득점kit.완전탐색.카펫;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=1; i*i<=yellow; i++){
            if(yellow%i==0){
                int width = yellow/i+2;
                int height = i+2;
                if(width*height-yellow==brown){
                    answer[0]=width;
                    answer[1]=height;
                    break;
                }
            }
        }
        return answer;
    }

    //다른 풀이1
    public int[] solution1(int brown, int red) {
        int a = (brown+4)/2;
        int b = red+2*a-4;
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int brown = 10;
        int yellow = 2;
        for(int x : T.solution(brown, yellow))
            System.out.print(x + " ");
    }
}


/*
 * yellow - brown
 * 1개      8
 * 2개      10
 * 3개      12
 * 4개      14, 16 - 4 = 12
 * 5개      16 
 * 6개      18   20-6=14
 * 7개      20   
 * 8개      22   24-8=16
 * 9개      24   25-9=16
 * 
 * 24          
 * 
 * 1. 약수 순서쌍을 구한다.
 * 2. +2 * +2 해서 개수가 맞는지 확인한다.
 * 3. 길이 내림차순으로 출력.
 */