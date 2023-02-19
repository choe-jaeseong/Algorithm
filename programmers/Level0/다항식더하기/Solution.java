package Level0.다항식더하기;

public class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int[] coef = new int[2];
        String[] poly = polynomial.split(" ");
        int sign = 1;
        for(String x : poly){
            if(x.equals("+") || x.equals("-")){
                if(x.equals("-")) sign = -1;
                else sign = 1;
            }
            else if(x.contains("x")){
                if(x.charAt(0)=='x') coef[0] += sign * 1;
                else coef[0] += sign * Integer.parseInt(x.substring(0, x.length()-1));
            } else {
                coef[1] += sign * Integer.parseInt(x);
            }
        }
        if(coef[0]!=0){
            answer += coef[0];
            answer += "x";
        }
        if(coef[1]!=0){
            answer += " ";
            if(coef[1]>0){
                answer += "+ ";
                answer += Math.abs(coef[1]);
            } else {
                answer += "- ";
                answer += Math.abs(coef[1]);
            }
        }
        return answer;
    }

    //다른 풀이1
    public String solution1(String polynomial) {
		int coef = 0;   // 계수
		int cons = 0;   // 상수
		for (String p : polynomial.split(" ")) {
			if (p.contains("x")) coef += p.equals("x") ? 1 : Integer.parseInt(p.substring(0, p.length() - 1));
			else if (!p.equals("+")) cons += Integer.parseInt(p);
		}
		String coefStr = coef > 0 ? coef == 1 ? "x" : coef + "x" : "";
		String consStr = cons > 0 ? String.valueOf(cons) : "";
		String result = "";
		if (coef > 0) {
			if (cons > 0) result += coefStr + " + " + consStr;
			else result += coefStr;
		}
		else if (cons > 0) result += consStr;
		return result;
	}

    //다른 풀이2
    public String solution2(String polynomial) {
        int xCount = 0;
        int num = 0;

        for (String s : polynomial.split(" ")) {
            if (s.contains("x")) {
                xCount += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            } else if (!s.equals("+")) {
                num += Integer.parseInt(s);
            }
        }
        return (xCount != 0 ? xCount > 1 ? xCount + "x" : "x" : "") + (num != 0 ? (xCount != 0 ? " + " : "") + num : xCount == 0 ? "0" : "");
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String x = "13x";
        int sign = -1;
        int ans = sign * Integer.valueOf(x.substring(0, x.length()-1));
        System.out.println(ans);
        System.out.println(T.solution("x + x + x"));

    }
}
