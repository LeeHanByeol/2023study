class Solution {
    public int[] solution(int n, String[] words) {

        int turn = 100;
        int loser = 100;
        
        //O(n^2)
        for(int i  = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(words[i].equals(words[j])){  //탈락자 발생
                    turn = j/n + 1;
                    loser = j%n + 1;                    
                    break;
                }
            }
        }
        
        int turn_1 = 100;
        int loser_1 = 100;
        
        //O(n)
        char endCh = words[0].charAt(words[0].length() - 1);
        for(int i = 1; i < words.length - 1; i++){
            char startCh = words[i].charAt(0);
            if(endCh == startCh){
                endCh = words[i].charAt(words[i].length()-1);
                continue;
            }
            
            //탈락자 발생
            turn_1 = i/n + 1;
            loser_1 = i%n + 1;
            break;
        }
        
        if(turn == 100 && turn_1 == 100){
            return new int[]{0,0};
        }
        if(turn < turn_1){
            return new int[]{loser, turn};
        }
        if(turn == turn_1){
            return (loser < loser_1) ? new int[]{loser, turn} : new int[]{loser_1, turn_1}; 
        }
        return new int[]{loser_1, turn_1};
        
    }
}