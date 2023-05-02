package Book.문자열.문자열압축;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> split(String source, int length){
        List<String> tokens = new ArrayList<>();
        //source를 length만큼 잘라 tokens 리스트에 추가
        for(int startIndex=0; startIndex<source.length(); startIndex+=length){
            int endIndex = startIndex + length;
            if(endIndex > source.length()) endIndex = source.length();
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }
    private int compress(String source, int length){
        StringBuilder builder = new StringBuilder();

        for(String token : split(source, length)) {
            
        }
        //압축한 문자열의 길이 반환

        return builder.length();
    }
    public int solution(String s){
        int min = Integer.MIN_VALUE;
        for(int i=1; i<=s.length(); i++){
            //문자열 압축 후 가장 짧은 길이 선택
        }
        return min;
    }
}
