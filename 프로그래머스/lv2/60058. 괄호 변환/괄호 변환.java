import java.util.*;
class Solution {
    
    
    public String solution(String p) {
        return divide(p);
    }
    
    public String divide(String w){ //2~4
        
        if(w.equals("")){
            return "";
        }
        
        boolean isRight = (w.charAt(0) == '(') ? true : false;
        
        int left = 0, right = 0;            //left: '(', right: ')'        
        int idx = 0;
        for(; idx < w.length(); idx++){      //u,v 분리

            if(w.charAt(idx) == '(') left++;
            else right++;
            
            if(left == right){
                idx++;
                break;
            }            
        }
        
        String u = w.substring(0, idx);
        String v = w.substring(idx);
        
        if(isRight){                //3번
            return u + divide(v);
        }
        
        //4번
        return '(' + divide(v) + ')' + fix_u(u);
        
    }
    
    public String fix_u(String u){
        
        int len = u.length();
        
        StringBuilder stb = new StringBuilder();
        for(int i = 1; i < len - 1; i++){
            if(u.charAt(i) == '('){
                stb.append(')');
            }
            else{
                stb.append('(');
            }
        }
        
        return stb.toString();
    }
    
    
}