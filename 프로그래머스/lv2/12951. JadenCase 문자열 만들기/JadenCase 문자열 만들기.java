//trim()을 썼다가 말았다. 공백으로 시작하거나 끝나는 문자열도 있는듯

//공백이 여러개일 수 있다길래 String의 split(정규식) 사용하려 했는데, 그러면 공백을 저장할 수가 없었음.
//따라서 구분자도 token으로 저장할 수 있는 StringTokenizer를 사용하였다.
//split은 데이터를 잘라 String[]으로 반환하기에, 데이터를 토큰으로 바로바로 잘라서 반환하는 StringTokenizer보다 느리다.

//문자열 변경이 필요했기에 StringBuffer 사용했음.
//String으로 변경하면, 새 주소에 할당하고 참조변수가 가리키는 주소를 바꾸는 거라 좀 느릴 것 같아서...
//연산 많은 것도 아닌데 크게 차이가 있겠냐만...

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
