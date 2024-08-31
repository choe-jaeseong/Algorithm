class Solution {
    
    private static int subscriber = 0;
    private static int sales = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        //이모티콘 할인율에 따른 경우의 수를 모두 구한다.
        DFS(0, new int[emoticons.length], users, emoticons);
        return new int[]{subscriber, sales};
    }
    private static void DFS(int d, int[] discount, int[][] users, int[] emoticons) {
        if(d == discount.length) {
            //각 경우에서 나올 수 있는 서비스 가입자수와 판매액을 기입한다.
            int[] result = find(discount, users, emoticons);
            if(result[0] > subscriber) {
                subscriber = result[0];
                sales = result[1];
            } else if(result[0] == subscriber) {
                if(result[1] > sales) 
                    sales = result[1];
            }
            return;
        }
        
        for(int i=0; i<4; i++) {
            discount[d] = (i + 1) * 10;
            DFS(d + 1, discount, users, emoticons);
        }
    }
    private static int[] find(int[] discount, int[][] users, int[] emoticons) {
        int sub = 0;
        int sales = 0;
        //각자 구매할 이모티콘 금액의 합을 구한다.
        int[] price = new int[users.length];
        for(int i=0; i<price.length; i++) {
            for(int j=0; j<emoticons.length; j++) {
                if(discount[j] >= users[i][0]) {
                    price[i] += (emoticons[j] * (100 - discount[j]) / 100);
                }
            }
            //일정 금액을 넘어가면 서비스 이용 가입한다.
            if(price[i] >= users[i][1]) sub++;
            else sales += price[i];
        }
        return new int[]{sub, sales};
    }
}