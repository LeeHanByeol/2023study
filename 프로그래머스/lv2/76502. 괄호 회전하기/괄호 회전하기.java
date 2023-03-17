import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            if(isRight(s.substring(i) + s.substring(0, i))){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isRight(String s){
        
        Stack <Character> stk = new Stack<>();
        
        for(char c : s.toCharArray()){
            switch(c){
                case '(', '{', '[':
                    stk.push(c);
                    break;
                case ')':
                    if(!stk.empty() && stk.peek() == '('){
                        stk.pop();
                        break;
                    }
                    return false;
                case '}':
                    if(!stk.empty() && stk.peek() == '{'){
                        stk.pop();
                        break;
                    }
                    return false;
                case ']':
                    if(!stk.empty() && stk.peek() == '['){
                        stk.pop();
                        break;
                    }
                    return false;                    
            }
        }
        
        if(stk.empty()){
            return true;
        }
        
        return false;
        
        
    }
}