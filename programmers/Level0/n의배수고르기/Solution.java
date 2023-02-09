package Level0.n의배수고르기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x : numlist){
            if(x%n==0) arr.add(x);
        }
        Integer[] arr1 = new Integer[arr.size()];
        arr1 = arr.toArray(arr1);
        int[] b = Arrays.stream(arr1).mapToInt(Integer::intValue).toArray(); 
        return b;
    }

    //다른 풀이1
    public int[] solution1(int n, int[] numList) {
        return Arrays.stream(numList).filter(value -> value % n == 0).toArray();
    }
    //다른 풀이2
    public int[] solution2(int n, int[] numlist) {
        ArrayList<Integer> List = new ArrayList<>();
        for(int i = 0;i < numlist.length; i++){
            if(numlist[i] % n == 0){
                List.add(numlist[i]);}}
            int[] answer = new int[List.size()];
            for(int i = 0; i< List.size(); i++){
                answer[i] = List.get(i);
                }
        return answer;
    }
    //다른 풀이3
    public int[] solution3(int n, int[] numlist) {
        List<Integer> answer = new ArrayList<>();
        for(int num : numlist){
            if(num % n == 0){
                answer.add(num);
            }
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
    //다른 풀이4
    public int[] solution4(int n, int[] numlist) {
        List<Integer> answerList = new ArrayList<Integer>();
        for(Integer i : numlist){
            if(i % n == 0){
                answerList.add(i);
            }
        }
        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        return answer;
    }
    //다른 풀이5
    public int[] solution5(int n, int[] numlist) {

        List<Integer> list = new ArrayList<>();

        for(int i : numlist){
            if(i%n==0) list.add(i);
        }

        int[] answer = list.stream()
            .mapToInt(i ->i)
            .toArray();

        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1,2,3,4,5,6};
        for(int x : T.solution(2, arr)) System.out.print(x + " ");
    }
}
