package 정렬.문자열내림차순으로배치하기;

/*
 * 1. 문자열을 내림차순으로 정렬
 */
public class Solution1 {
    public String solution(String s) {
        return s.chars()
                        .boxed()
                        .sorted((a,b)->b - a)
                        .collect(StringBuilder::new,
                                 StringBuilder::appendCodePoint,
                                 StringBuilder::append)
                        .toString();
    }
}
