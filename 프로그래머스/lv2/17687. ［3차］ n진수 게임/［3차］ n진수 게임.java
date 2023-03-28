import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        p -= 1;     //index로 접근할거라 1 빼줌
        String answer = "";
        
        int num = 0, len = 0;
        char[] window = new char[m];
        while(answer.length() < t){
            String str = Integer.toString(num, n);  //n진법으로 변환
            int leftSize = m - len;
            if(leftSize > str.length()){   //다 들어갈 자리가 남아있다면
                for(char a : str.toCharArray()){
                    window[len++] = a;
                }
            }
            else{   //자리가 남아있지 않다면
                for(char a : str.substring(0, leftSize).toCharArray()){   //채울 수 있을 때까지 채운다
                    window[len++] = a;
                }
                answer += window[p];
                len = 0;                            //window 초기화하고
                for(char a : str.substring(leftSize).toCharArray()){  //남은 글자 다시 채워줌
                    window[len++] = a;
                }
            }
            num++;            
        }
        
        return answer.toUpperCase();
    }
}