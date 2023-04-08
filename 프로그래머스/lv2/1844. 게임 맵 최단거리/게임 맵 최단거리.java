import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps, maps.length, maps[0].length);
    }
    
    public class Node{
        int x, y, cost;
        
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    public int bfs(int[][] maps, int n, int m){
        
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        Node root = new Node(m-1, n-1, 1);
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if(x == 0 && y == 0){   //(0,0) 도착 성공
                return node.cost;   //bfs는 가장 먼저 도착하는 경로가 최단경로이다.
            }

            //visited를 동서남북 코드 안에서 바꿔주어야, 큐에 노드가 중복으로 들어가지 않는다.
            if(0 < y && maps[y-1][x] == 1 && visited[y-1][x] == false){    //위로 이동 가능
                queue.add(new Node(x, y-1, node.cost+1));
                visited[y-1][x] = true;
            }
            if(y < n-1 && maps[y+1][x] == 1 && visited[y+1][x] == false){  //아래로 이동 가능
                queue.add(new Node(x, y+1, node.cost+1));
                visited[y+1][x] = true;                
            }
            if(0 < x && maps[y][x-1] == 1 && visited[y][x-1] == false){    //좌로 이동 가능
                queue.add(new Node(x-1, y, node.cost+1));
                visited[y][x-1] = true;
            }
            if(x < m-1 && maps[y][x+1] == 1 && visited[y][x+1] == false){    //우로 이동 가능
                queue.add(new Node(x+1, y, node.cost+1));
                visited[y][x+1] = true;                
            }            
        }
        return -1;
        
    }
    
}