import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        String answer = "";
        String str = "";
        for(int i = 0; i < t*m; i++){
            str += Integer.toString(i, n);
        }

        int order = 1;        
        for(int i = 0; i < str.length(); i++){
            if(answer.length() == t){
                break;
            }
            if(order > m){
                order = 1;
            }
            if(order == p){
                answer += str.charAt(i);
            }
            order++;
        }
        
        return answer.toUpperCase();
    }
}