package Level1.신규아이디추천;

public class Solution {
    public String solution(String new_id) {
        //1.단계
        char[] arr = new_id.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=65&&arr[i]<=90) arr[i]+=32;
        }
        new_id = String.valueOf(arr);
        System.out.println("1 "+new_id);
        //2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        System.out.println("2 "+ new_id);
        //3단계
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<new_id.length()-1; i++){
            if(new_id.charAt(i)=='.' && new_id.charAt(i+1)=='.') continue;
            else sb.append(new_id.charAt(i));
        }
        sb.append(new_id.charAt(new_id.length()-1));
        new_id = sb.toString();
        System.out.println("3 "+new_id);
        //4단계
        if(new_id.length()>1){
            if(new_id.charAt(0)=='.')
                new_id = new_id.substring(1);
            if(new_id.charAt(new_id.length()-1)=='.')
                new_id = new_id.substring(0,new_id.length()-1);
        } else {
            if(new_id.charAt(0)=='.')
                new_id = "";
        }
        System.out.println("4 "+new_id);
        //5단계
        if(new_id.equals("")) new_id+="a";
        System.out.println("5 "+new_id);
        //6단계
        if(new_id.length()>15) new_id = new_id.substring(0, 15);
        if(new_id.length()>1){
            if(new_id.charAt(0)=='.')
                new_id = new_id.substring(1);
            if(new_id.charAt(new_id.length()-1)=='.')
                new_id = new_id.substring(0,new_id.length()-1);
        } else {
            if(new_id.charAt(0)=='.')
                new_id = "";
        }
        System.out.println("6 "+new_id);
        //7단계
        if(new_id.length()<=2){
            while(new_id.length()!=3) {
                int idx = new_id.length()-1;
                new_id+=new_id.charAt(idx);
            }
        }
        System.out.println("7 "+new_id);
        return new_id;
    }
    //다른 풀이1
    public String solution1(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();
        System.out.println("1. "+temp);
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println("2. "+temp);
        temp = temp.replaceAll("[.]{2,}","."); //.이 2개이상
        System.out.println("3. "+temp);
        temp = temp.replaceAll("^[.]|[.]$","");//^시작점, | or, $끝점
        System.out.println("4. "+temp);
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        System.out.println("5. "+temp);
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
    public static void main(String[] args) {
        Solution T = new Solution();
        String str = "...!@BaT#*..y.abcdefghijklm";
        System.out.println(T.solution1(str));
    }
}
