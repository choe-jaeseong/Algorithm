package 고득점kit.완전탐색.소수찾기;

import java.util.TreeSet;

public class Solution {
    TreeSet<Integer> tset = new TreeSet<>();
    int[] ch;
    String tmp = "";
    public void DFS(int L, int k, String numbers){
        if(L==k){
            if(tmp.equals("")) return ;
            tset.add(Integer.parseInt(tmp));
        }
        for(int i=0; i<numbers.length(); i++){
            if(ch[i]==0){
                ch[i]=1;
                tmp+=numbers.charAt(i);
                DFS(L+1,k,numbers);
                tmp=tmp.substring(0,tmp.length()-1);
                ch[i]=0;
            }
        }
    }
    public boolean isPrime(int x){
        if(x<=1) return false;
        for(int i=2; i*i<=x; i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public int solution(String numbers) {
        int answer = 0;
        ch = new int[numbers.length()];
        for(int i=1; i<=numbers.length(); i++){
            DFS(0,i,numbers);
        }
        for(int x : tset){
            System.out.print(x+" ");
            if(isPrime(x)) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution("011"));
    }
}


/*
 * 1. 경우의 수를 모두 찾기
 * 2. 소수 분류하기
 */