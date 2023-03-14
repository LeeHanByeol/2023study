import java.util.*;

class Solution {
    public int[] solution(String s) {

        int num_0 = 0, num_trans = 0;
        int s_len = s.length();
        
        while(!s.equals("1")){
            //0 제거
            s = s.replaceAll("0", "");
            num_0 += (s_len - s.length());
            //이진변환
            s = Integer.toBinaryString(s.length());
            num_trans++;

            s_len = s.length();     //새 s의 길이로 update
        }
        
        int[] answer = {num_trans, num_0};
        return answer;
    }

}