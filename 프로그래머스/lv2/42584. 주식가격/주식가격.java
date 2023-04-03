import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < prices.length; i++){

            while(!stk.empty() && prices[stk.peek()] > prices[i]){
                int num = stk.pop();
                answer[num] = i - num; 
            }

            stk.push(i);            
        }
        
        int maxIdx = stk.peek();
        while(!stk.empty()){
            answer[stk.peek()] = maxIdx - stk.pop();
        }
        
        return answer;
    }
}