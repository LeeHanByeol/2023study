import java.util.*;
class Solution {
    
    class Music{
        int playTime;
        String name;
        String music;       
        
        public Music(String str){
            String[] info = str.split(",");
            this.playTime = cal_time(info[0], info[1]);
            this.name = info[2];
            this.music = draw_music(remove_sharp(info[3]), this.playTime);
        }
        
        public int cal_time(String start, String end){
            String[] temp = start.split(":");
            int s = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            temp = end.split(":");
            int e = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            return e - s;
        }
        
        public String draw_music(String str, int playTime){
            
            while(str.length() < playTime){
                str += str;
            }
            return str.substring(0, playTime);            
        }
        
    }
    
    
    public String solution(String m, String[] musicinfos) {
        
        Music answer = new Music("0:00,0:00,(None),No");
        m = remove_sharp(m);
        
        for(int i = 0; i < musicinfos.length; i++){            
            Music candidate = new Music(musicinfos[i]);
            if(candidate.music.contains(m) && answer.playTime < candidate.playTime){
                answer = candidate;
            }            
        }
        
        return answer.name;
    }
    
    public String remove_sharp(String str){
        return str.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
    }
}