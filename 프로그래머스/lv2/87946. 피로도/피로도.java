class Solution {
    
    public static boolean visited[];
    
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        return explore(k, dungeons);
    }
    
    
    public static int explore(int cur_distress, int[][] dungeons){
        
        //dfs
        int count = 0;
        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && dungeons[i][0] <= cur_distress){
                visited[i] = true;
                count = Math.max(count, explore(cur_distress - dungeons[i][1], dungeons));
                visited[i] = false;
            }
        }

        return Math.max(count, count());
    }
    
    
    public static int count(){
        int answer = 0;
        for(int i = 0; i < visited.length; i++){
            answer += visited[i] ? 1 : 0;
        }
        return answer;
    }
}