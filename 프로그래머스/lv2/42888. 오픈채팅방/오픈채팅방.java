import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String, String> nickname = new HashMap<>();
        Queue<String> records = new LinkedList<>();
        
        for(String a : record){
            String[] cur = a.split(" ");
            
            if(cur[0].charAt(0) == 'L'){    //Leave
                records.add(cur[1]);
                continue;
            }
            if(cur[0].charAt(0) == 'E'){    //Enter
                records.add(cur[1]);
            }                        
            
            nickname.put(cur[1], cur[2]);   //consider nickname might be changed
        }

        
        String[] answer = new String[records.size()];
        int idx = 0;
                
        //user in chatRoom
        Set<String> isIn = new HashSet<>();
        for(String uid : records){
            
            if(isIn.remove(uid)){
                answer[idx++] = nickname.get(uid) + "님이 나갔습니다.";
            }
            else{
                isIn.add(uid);
                answer[idx++] = nickname.get(uid) + "님이 들어왔습니다.";
            }
        }
        
        return answer;
    }
}