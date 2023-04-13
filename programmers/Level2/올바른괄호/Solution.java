package Level2.올바른괄호;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(cnt==0){
                if(c==')') return false;
                else cnt++;
            } else {
                if(c==')') cnt--;
                else cnt++;
            }
            if(cnt<0) return false;
        }
        if(cnt!=0) return false;
        return answer;
    }
    
    //다른 내 풀이1
    boolean solution1(String s) {
        boolean answer = true;
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c=='(') cnt++;
            else cnt--;
            if(cnt<0) return false;
        }
        if(cnt!=0) return false;
        return answer;
    }

    //시간 초과
    // boolean solution(String s) {
    //     boolean answer = true;
    //     Stack<Character> stack = new Stack<>();
    //     for(char c : s.toCharArray()){
    //         if(stack.size()>s.length()/2) return false;
    //         if(stack.isEmpty()){
    //             if(c==')') return false;
    //             else stack.push(c);
    //         } else if(stack.peek()=='('){
    //             if(c==')') stack.pop();
    //             else stack.push(c);
    //         } else return false;
    //     }
    //     if(!stack.isEmpty()) return false;
    //     return answer;
    // }
    public static void main(String[] args) {
        Solution T = new Solution();
        String str = "(()(";
        System.out.println(T.solution(str));
    }
}
