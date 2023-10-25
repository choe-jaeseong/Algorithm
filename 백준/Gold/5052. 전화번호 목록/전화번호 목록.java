import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());

            //트라이 구조 생성
            Trie trie = new Trie();

            //번호 입력
            String[] phoneNum = new String[N];
            for(int i=0; i<N; i++) {
                phoneNum[i] = br.readLine();    //배열에 저장
                trie.insert(phoneNum[i]);       //트라이 구조에도 저장
            }

            //일관성 확인
            boolean answer = true;
            for(String number : phoneNum){
                if(!trie.isConsistency(number)){
                    answer = false;
                    break;
                }
            }

            //결과 출력
            if(answer) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

class Node {
    char c;
    Node[] child = new Node[10]; //전화번호는 0~9만 존재
    boolean isLeaf = true;

    public Node(char c) {
        this.c = c;
    }

    void insert(String str, int index){
        //문자열을 끝까지 확인했다면 종료
        if(index == str.length()) return;

        //이번에 저장할 문자 인덱스의 노드가 null 이라면 새로 생성
        char tmp = str.charAt(index);
        int tmpIdx = str.charAt(index) - '0';
        if(this.child[tmpIdx] == null || this.isLeaf) {
            this.child[tmpIdx] = new Node(tmp);
            this.isLeaf = false;
        }

        //다음 문자 저장
        this.child[tmpIdx].insert(str, index + 1);
    }

    boolean isConsistency(String str, int idx){
        //문자열을 끝까지 확인했다면 결과 리턴
        if (str.length() == idx) return isLeaf;
        //다음 문자 확인
        int tmpidx = str.charAt(idx) - '0';
        if(!this.isLeaf){
            if(this.child[tmpidx] != null)
                return this.child[tmpidx].isConsistency(str, idx + 1);
        }
        return false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node(' ');
    }

    void insert(String str) {
        root.insert(str, 0);
    }

    boolean isConsistency(String str) {
        return root.isConsistency(str, 0);
    }
}

/*
1. 트리 구조를 만든다.
2. 입력 받는 문자를 배열에 넣으면서, 트리 구조에도 값을 넣는다.
3. 문자를 순회하면서, 트리 구조에서 일관성이 있는지 확인한다.
 */