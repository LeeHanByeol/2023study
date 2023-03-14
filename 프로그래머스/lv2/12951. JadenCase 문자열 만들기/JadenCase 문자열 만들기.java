import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while(st.hasMoreTokens()){
            StringBuffer str = new StringBuffer(st.nextToken());
            if(97 <= str.charAt(0) && str.charAt(0) <= 122){    //if a~z
                str.setCharAt(0, (char)(str.charAt(0) - 32));   //대문자로
            }
            answer += str.toString();
        }

        return answer;
    }
}