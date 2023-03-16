import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(!stk.empty() && (stk.peek() == s.charAt(i))){
                stk.pop();
                continue;
            }
            stk.push(s.charAt(i));
        }
        
        if(stk.empty()){
            return 1;
        }
        else{
            return 0;
        }
    }
}