import java.util.*;
class Solution {
    
    int nodeNum;                //num of nodes
    boolean[][] map;            //map[a][b] : are node A and B connected?
    boolean[] visited;          //this node is already visited
    int answer = 100;           //min of difference

    public int solution(int n, int[][] wires) {

        //initialize
        nodeNum = n;
        visited = new boolean[n+1];
        map = new boolean[n+1][n+1];
        for(int[] wire : wires){
            map[wire[0]][wire[1]] = map[wire[1]][wire[0]] = true;
        }
        
        dfs(1);

        return answer;
    }
    
    public int dfs(int node1){
        
        visited[node1] = true;
        int child = 1;
        for(int node2 = 1; node2 <= nodeNum; node2++){
            if(!visited[node2] && map[node1][node2]){
                child += dfs(node2);
            }
        }
        
        int diff = (child<<1) - nodeNum;     //diff = child - (nodeNum - child);
        if(diff < 0) diff = ~diff+1;         //abs

        answer = (answer < diff) ? answer : diff;
        
        return child;
    }
    

}