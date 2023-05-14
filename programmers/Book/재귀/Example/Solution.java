package 재귀.Example;

/*
 * 문제 : 0 이상의 두 정수 n,m이 주어졌을 때, n^m 의 값을 구하시오.
 */
public class Solution {
    public int power(int n, int m){
        if(m==0) return 1;
        if(n==1) return 1;
        if(n==0) return 1;

        return n * power(n, m-1);
    }
}
