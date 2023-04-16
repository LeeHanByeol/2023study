import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        int len = number.length() - k;      //잘라낸 후 문자열의 길이
        
        Stack<Character> stk = new Stack<>();
        
        for(char num : number.toCharArray()){
            
            while((k > 0) && (!stk.empty()) && (stk.peek() < num)){
                stk.pop();
                k--;
            }
            stk.push(num);            
        }
        
        return stk.toString().replaceAll(", ", "").substring(1, len+1);    //,와 [] 잘라냄
    }
}