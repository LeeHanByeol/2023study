//Stack 사용

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(stk.empty()){    //스택이 비었다면 조건없이 넣어줌
                stk.push(c);
                continue;
            }
            if(stk.peek() == c){    //같은 문자라면
                stk.pop();          //pop
            }
            else{                   //다른 문자라면
                stk.push(c);        //스택에 넣어준다
            }
        }
        
        //연산 끝내고 스택이 비었으면 1, 아니라면 0
        return stk.empty() ? 1 : 0;
        
    }
}