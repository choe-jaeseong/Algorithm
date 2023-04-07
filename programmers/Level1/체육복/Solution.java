package Level1.체육복;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    //다른 풀이1
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
    //다른 풀이2
    public int solution2(int n, int[] lost, int[] reserve) {
        int count = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0; i < lost.length; i++) {
            for(int j=0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }
        for (int i=0; i < lost.length; i++) {
            for (int j=0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1) {
                    count++;
                    reserve[j] = -1;
                    break;

                }
            }
        }
        return n - lost.length + count;
    }
    //다른 풀이3
    public int solution3(int n, int[] lost, int[] reserve) {
        int answer=n-lost.length;
        HashSet<Integer> ko = new HashSet<Integer>();
        for(int k : reserve) {
            ko.add(k);
        }
        for(int i =0;i<lost.length;i++) {
            if(ko.contains(lost[i])) {
                //System.out.println("내껀내가입지");
                answer++;
                ko.remove(lost[i]);
                lost[i]=-1;
            }
        }


        for(int i =0;i<lost.length;i++) {
            //System.out.println(i);

            if(ko.contains(lost[i]-1)) {
                //System.out.println("있다");
                answer++;
                ko.remove(lost[i]-1);
            }else if(ko.contains(lost[i]+1)) {
                //System.out.println("있다");
                answer++;
                ko.remove(lost[i]+1);
            }
            //System.out.println("없다");
        }


        return answer;
    }
    // public int solution(int n, int[] lost, int[] reserve) {
    //     Arrays.sort(lost);
    //     Arrays.sort(reserve);
    //     int answer = n-lost.length;
    //     int[] ch = new int[reserve.length];
    //     for(int j=0; j<reserve.length; j++){
    //         for(int i=0; i<lost.length; i++){
    //             if(reserve[j]==lost[i]) {
    //                 ch[j]=1;
    //                 answer++;
    //             }
    //         }
    //     }
    //     for(int i=0; i<lost.length; i++){
    //         for(int j=0; j<reserve.length; j++){
    //             if(lost[i]+1<reserve[j]) break;
    //             if(ch[j]==0 && (lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1)){
    //                 answer++;
    //                 ch[j]=1;
    //                 break;
    //             }
    //         }
    //     }
        
    //     return answer;
    // }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {2,4};
        int[] arr2 = {1,3,5};
        System.out.println(T.solution(5, arr1, arr2));
    }
}
