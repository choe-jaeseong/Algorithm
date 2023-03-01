package Level1.햄버거만들기;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    //첫 번째 풀이 - 시간 초과!
    public int solution(int[] ingredient) {
        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<ingredient.length; i++){
            list.add(ingredient[i]);
        }
        boolean flag = true;
        while(list.size()>0){
            if(list.size()<4) return ans;
            if(flag==false) return ans;
            for(int i=0; i<list.size()-3; i++){
                if(list.get(i)==1 && list.get(i+1)==2 && list.get(i+2)==3 && list.get(i+3)==1){
                    ans++;
                    list.remove(i+3);
                    list.remove(i+2);
                    list.remove(i+1);
                    list.remove(i);
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
        }
        return ans;
    }

    //두 번째 풀이
    public int solution2(int[] ingredient) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int in : ingredient){
            stack.push(in);

            //스택 사이즈 4이상이 되면 조건 처리 시작
            if(stack.size() >= 4){
                //스택 안에 1231이 연이어 들어있을 경우
                if(stack.get(stack.size()-4)==1
                && stack.get(stack.size()-3)==2
                && stack.get(stack.size()-2)==3
                && stack.get(stack.size()-1)==1) {

                    ans++;
                    stack.pop(); stack.pop(); stack.pop(); stack.pop();
                }
            }
        }
        return ans;
    }

    
    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(T.solution2(arr));
    }
}
