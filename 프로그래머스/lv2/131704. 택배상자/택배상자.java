import java.util.*;
class Solution {
    public int solution(int[] order) {
        
        int main = 1;                           //컨테이너 벨트
        Stack<Integer> sub = new Stack<>();     //보조 컨테이너 벨트

        int answer = 0;
        
        loop1: 
        for(int boxNum : order){
            if(sub.isEmpty()){
                sub.add(0);
            }
            while(true){
                if(sub.peek() == boxNum){ 
                    sub.pop();
                    break;
                }
                if(main == boxNum){
                    main++;
                    break;
                }
                if(sub.peek() > boxNum){
                    break loop1;
                }
                sub.add(main++);
            }
            answer++;
        }
        
        return answer;
    }
}