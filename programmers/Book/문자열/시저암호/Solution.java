package Book.문자열.시저암호;

public class Solution {

    //답안
    private char push(char c, int n){
        //c를 n만큼 밀어 반환
        if(!Character.isAlphabetic(c)) return c;

        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position+n)%26;
        return (char)(offset + position);
    }
    public String solution1(String s, int n){
        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()){
            builder.append(push(c, n));
        }
        return builder.toString();
    }


    //나의 답
    public String solution(String s, int n){
        //1. 문자열을 char 배열로 변환
        char[] arr = s.toCharArray();
        //2. 배열 순회
        for(int i=0; i<arr.length; i++){
            if(arr[i]==' ') continue;
            if(arr[i]>=65 && arr[i]<=90){
                arr[i] = (char)((arr[i]-'A'+n)%26 + 'A');
            } else {
                arr[i] = (char)((arr[i]-'a'+n)%26 + 'a');
            }
        }
        //3. 문자열로 변환
        return new String(arr);
    }
}
