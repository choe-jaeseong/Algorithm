package Level2.JadenCase문자열만들기;

public class Solution {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        if(arr[0]>=97 && arr[0]<=122) arr[0]-=32;
        for(int i=1; i<s.length(); i++){
            if(arr[i-1]==' ' && arr[i]>=97 && arr[i]<=122){
                arr[i]-=32;
            }
        }
        return String.valueOf(arr);
    }
    
    //다른 풀이1
    public String solution1(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;
        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        return answer;
  }
  
  
    public static void main(String[] args) {
        Solution T = new Solution();
        String str = "3people          unFollowed me";
        System.out.println(T.solution(str));
    }
}
