import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        File[] F = new File[files.length];
        for(int i=0; i<files.length; i++) F[i] = new File(i, files[i]);
        
        Arrays.sort(F);
        
        String[] answer = new String[files.length];
        for(int i=0; i<answer.length; i++) answer[i] = F[i].name;
        return answer;
    }
    
    private static String[] parse(String file) {
        String[] result = new String[3];
        
        int start = 0;
        int idx = 0;
        while(!Character.isDigit(file.charAt(idx))) idx++;
        result[0] = file.substring(start, idx);
        start = idx;
        while(idx < file.length() && Character.isDigit(file.charAt(idx))) idx++;
        result[1] = file.substring(start, idx);
        
        if(idx == file.length()) {
            result[2] = "";
        } else {
            result[2] = file.substring(idx);
        }
        
        return result;
    }
    
    static class File implements Comparable<File> {
        int idx;
        String name;
        String head;
        int num;
        String tail;
        
        File(int i, String file) {
            idx = i;
            name = file;
            String[] parsed = parse(file);
            head = parsed[0].toLowerCase();
            num = Integer.parseInt(parsed[1]);
            tail = parsed[2];
        }
        
        @Override
        public int compareTo(File f) {
            if(this.head.equals(f.head)) {
                if(this.num == f.num) {
                    return this.idx - f.idx;
                }
                return this.num - f.num;
            }
            return this.head.compareTo(f.head);
        }
    }
}