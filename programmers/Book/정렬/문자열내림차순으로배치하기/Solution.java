package 정렬.문자열내림차순으로배치하기;

public class Solution {
    public String solution(String s){
        return s.chars()                            //intStream
                        .boxed()                    //Integer
                        .sorted((v1, v2)->v2 - v1)  //sort 역순    //collect : 모든 원소를 하나의 객체로 통합하는 메서드 (매개변수 세 가지, supplier, accumulator, combiner)
                        .collect(StringBuilder::new,              //supplier
                                 StringBuilder::appendCodePoint,  //accumulator
                                 StringBuilder::append)           //combiner
                        .toString();        
    }
}
