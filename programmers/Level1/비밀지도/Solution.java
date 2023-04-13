package Level1.비밀지도;

/*
 * 1. 두 숫자 배열을 이진수 String 배열로 바꾸기.
 * 2. 1이 하나라도 있으면 #으로 출력.
 */
public class Solution {
    static int len;
    public String getBinary(int n){
        String ans = "";
        String x = Integer.toString(n, 2);
        for(int i=0; i<len-x.length(); i++) ans+="0";
        return ans+x;
    }
    public String[] getBinaryArray(int[] arr){
        String[] ans = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            ans[i]=getBinary(arr[i]);
        }
        return ans;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        len = n;
        String[] answer = new String[n];
        String[] a1 = getBinaryArray(arr1);
        String[] a2 = getBinaryArray(arr2);
        StringBuilder sb;
        for(int i=0; i<n; i++){
            sb = new StringBuilder();
            for(int j=0; j<n; j++){
                if(a1[i].charAt(j)=='0' && a2[i].charAt(j)=='0')
                    sb.append(" ");
                else 
                    sb.append("#");
            }
            answer[i]=sb.toString();
        }
        return answer;
    }


    //다른 풀이1
    public String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }
        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
    //다른 풀이2 (풀이1 속도 개선 : substring)
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String temp;
  
        for(int i = 0 ; i < n ; i++){
            temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            temp = temp.substring(temp.length() - n);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }
  
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 5;
        int[] arr = {9, 20, 28, 18, 11};
        int[] arr2= {30, 1, 21, 17, 28};
        for(String x : T.solution(n, arr, arr2)) System.out.println(x);
    }
}
