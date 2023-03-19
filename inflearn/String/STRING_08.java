package String;
// 8. 유효한 팰린드롬
import java.util.*;

class STRING_08 {
	public String solution(String s){
		String answer = "NO";
		s = s.toUpperCase().replaceAll("[^A-Z]", "");
		String tmp=new StringBuilder(s).reverse().toString();
		if(s.equals(tmp)) answer="YES";
		return answer;
	}
	
	public static void main(String[] args){
		STRING_08 T = new STRING_08();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.print(T.solution(str));
		sc.close();
	}
}