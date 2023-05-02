package Book.문자열.자연수뒤집어배열로만들기;

public class Solution {
    public int[] solution(Long n){
        //나의 답
        // //1. 숫자를 문자열로 변환
        // StringBuilder sb = new StringBuilder(n+"");
        // //2. 문자를 뒤집음.
        // String num = sb.reverse().toString();
        // //3. 문자열 길이의 배열을 생성
        // int[] arr = new int[num.length()];
        // //4. 문자열을 숫자 배열로 변환
        // for(int i=0; i<arr.length; i++){
        //     arr[i] = num.charAt(i)-'0';
        // }
        // return arr;

        //답안
        String str = Long.toString(n);
        String reversed = new StringBuilder(str).reverse().toString();
        char[] arr = reversed.toCharArray();
        
        int[] result = new int[arr.length];
        for(int i=0; i<result.length; i++){
            result[i] = arr[i] - '0';
        }
        return result;
    }
}
