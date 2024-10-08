import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;

        Stack<Integer> 보조 = new Stack<>();
        Queue<Integer> 기존 = new LinkedList<>();

            for(int i=0; i<order.length; i++){
                보조.add(i+1);

                while(!보조.isEmpty()){
                    if(보조.peek() == order[cnt]){
                        기존.offer(보조.pop());
                        cnt++;
                    }else break;

                }
            }
        // System.out.println("보조 : " + 보조.toString());
        // System.out.println("기존 : " + 기존.toString());
        answer = 기존.size();
        return answer;
    }
}


// import java.util.*;

// class Solution {
//     public int solution(int[] order) {
//         int answer = 0;
//         Stack<Integer> stack = new Stack<>();
//         int idx = 0;
//         for(int i=1; i<=order.length; i++) {
//             if(order[idx] == i) {
//                 answer++;
//                 idx++;
//             } else if (!stack.isEmpty() && order[idx] == stack.peek()){
//                 answer++;
//                 stack.pop();
//                 idx++;
//                 i--;
//             } else {
//                 stack.add(i);
//             }
//         }
//         while(idx < order.length 
//               && !stack.isEmpty() 
//               && order[idx] == stack.peek()) {
//             answer++;
//             stack.pop();
//             idx++;
//         }
//         return answer;
//     }
// }