import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        //옷 종류별 개수 파악
        HashMap <String, Integer> closet = new HashMap<>();        
        for(int i = 0; i < clothes.length; i++){
            int n = closet.getOrDefault(clothes[i][1], 0);
            closet.put(clothes[i][1], ++n);
        }

        //조합하기
        int answer = 1;
        for(String key : closet.keySet()){
            answer *= (closet.get(key)+1);    //+1: 안 입는 경우 포함
        }
        answer--;           //아무것도 안 입은 경우
        
        return answer;
    }
    
}