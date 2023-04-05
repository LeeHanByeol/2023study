import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        Set<String> visited = new HashSet<>();
        visited.add("stay");
        
        int[] cur_loc = {0, 0};     //xy 좌표
        for(char dir : dirs.toCharArray()){
            visited.add(move(cur_loc, dir));
        }

        return visited.size() - 1;      //stay 빼고
    }
    
    public static String move(int[] cur_loc, char dir){

        String prev = Arrays.toString(cur_loc);
        
        switch(dir){
            case 'U':
                if(cur_loc[1] < 5){
                    cur_loc[1]++;
                    return prev + Arrays.toString(cur_loc);
                }
                return "stay";
            case 'D':
                if(cur_loc[1] > -5){
                    cur_loc[1] --;
                    return Arrays.toString(cur_loc) + prev;
                }
                return "stay";
            case 'L':
                if(cur_loc[0] > -5){
                    cur_loc[0]--;
                    return Arrays.toString(cur_loc) + prev;
                }
                return "stay";
            case 'R':
                if(cur_loc[0] < 5){
                    cur_loc[0]++;
                    return prev + Arrays.toString(cur_loc);
                }
                return "stay";
        } 
        
        return "error";
    }
}