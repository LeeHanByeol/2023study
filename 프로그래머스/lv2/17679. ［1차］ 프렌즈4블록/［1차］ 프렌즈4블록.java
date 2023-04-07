import java.util.*;

class Solution {
    
    static char[][] bd = new char[30][30];
    
    public int solution(int m, int n, String[] board) {
        
        //보드 만들기; 대신 transpose 된 상태로 만든다
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                bd[j][i] = board[i].charAt(j);
            }
        }
        
        //
        int answer = 0;
        Set<Coordinate> set = new HashSet<>();
        while(true){
            for(int i = 0; i < n-1; i++){
                for(int j = 0; j < m-1; j++){
                    if(isMatch(i, j)){
                        set.add(new Coordinate(i, j));
                        set.add(new Coordinate(i+1, j));
                        set.add(new Coordinate(i, j+1));
                        set.add(new Coordinate(i+1, j+1));
                    }
                }
            }
            if(set.size() == 0) break;
            
            answer += set.size();
            bomb(set);
            reloc(m, n);
            set.clear();
            System.out.println(answer);            
        }

        return answer;
    }
    
    public class Coordinate{
        int x, y;
        
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(!(obj instanceof Coordinate)) return false;
            
            Coordinate temp = (Coordinate)obj;
            return (x == temp.x) && (y == temp.y);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x, y);
        }
    }
    
    public boolean isMatch(int x, int y){       //같은 블록 4개가 붙어있는가?
        if(bd[x][y] == '\0'){
            return false;
        }
        return (bd[x][y]==bd[x+1][y]) && (bd[x][y]==bd[x][y+1]) && (bd[x][y]==bd[x+1][y+1]);
    }
    
    public void bomb(Set<Coordinate> set){   //터질 블록을 널문자로 처리
        
        for(Coordinate cor : set){
            bd[cor.x][cor.y] = '\0';
        }
        return;
    }
    
    public void reloc(int m, int n){    //오른쪽으로 밀어서 빈 자리를 메꾼다
        for(int i = 0; i < n; i++){
            LinkedList<Character> notNull = new LinkedList<>();
            for(int j = 0; j < m; j++){
                if(bd[i][j] != '\0') notNull.add(bd[i][j]);
            }
            int boundary = m - notNull.size();
            for(int j = 0; j < boundary; j++){
                bd[i][j] = '\0';
            }
            for(Character c : notNull){
                bd[i][boundary++] = c;
            }
        }
        return;
    }
}