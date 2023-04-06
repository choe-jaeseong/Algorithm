package Level1.다트게임;

public class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        char[] arr = dartResult.toCharArray();
        //1. 점수 입력
        int i=0;    //score 인덱스
        for(int j=0; j<arr.length; j++){
            if(arr[j]=='1' && arr[j+1]=='0'){
                score[i++]=10; 
                j++;
            } else if(Character.isDigit(arr[j])){
                score[i++]=arr[j]-'0';
            }
        }
        //2. square 및 # * 계산
        i=0;
        dartResult = dartResult.replaceAll("[0-9]", "");
        System.out.println(dartResult);
        for(int j=0; j<dartResult.length(); j++){
            int c = dartResult.charAt(j);
            if(c=='S') score[i]=score[i];
            else if(c=='D') score[i]=(int)Math.pow(score[i], 2);
            else if(c=='T') score[i]=(int)Math.pow(score[i], 3);
            else if(c=='#') score[--i]*=-1;
            else if(c=='*') {
                score[--i]*=2;
                if(i-1>=0) score[i-1]*=2;
            }
            i++;
        }
        for(int x : score) answer+=x;
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("1D2S3T*"));
    }
}
