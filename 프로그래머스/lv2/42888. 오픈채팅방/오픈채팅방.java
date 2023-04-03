import java.util.*;

class Solution {
    
    public class UserInfo{
        String uid;
        String nickname;
        
        public UserInfo(String uid, String nickname){
            this.uid = uid;
            this.nickname = nickname;
        }
    }
    
    public class Command{
        char command;
        String uid;
        
        public Command(char command, String uid){
            this.command = command;
            this.uid = uid;
        }
    }
    
    
    public String[] solution(String[] record) {
        
        Map<String, UserInfo> users = new HashMap<>();
        Queue<Command> records = new LinkedList<>(); 
        

        for(String a : record){
            String[] cur = a.split(" ");
            switch(cur[0].charAt(0)){
                case 'E':
                    records.add(new Command('E', cur[1]));
                    users.put(cur[1], new UserInfo(cur[1], cur[2]));
                    break;
                case 'L':
                    records.add(new Command('L', cur[1]));
                    break;
                case 'C':
                    users.put(cur[1], new UserInfo(cur[1], cur[2]));
                    break;
            }
        }
        
        String[] answer = new String[records.size()];
        int idx = 0;
        for(Command a : records){
            switch(a.command){
                case 'E':
                    answer[idx++] = users.get(a.uid).nickname + "님이 들어왔습니다.";
                    break;
                case 'L':
                    answer[idx++] = users.get(a.uid).nickname + "님이 나갔습니다.";                    
                    break;
            }
        }
        
        return answer;
    }
}