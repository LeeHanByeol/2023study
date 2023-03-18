import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        final int CACHE_HIT = 1;
        final int CACHE_MISS = 5;
        
        //모두 소문자로 통일
        for(int i = 0; i < cities.length; i++){
            cities[i] = cities[i].toLowerCase();
        }
        
        //LRU 구현
        LinkedList<String> cache = new LinkedList<>();
        for(String s : cities){
            
            int idx = cache.indexOf(s);
            if(idx != -1){ //캐쉬에 저장되어있다면,
                cache.remove(idx);
                cache.add(s);
                answer += CACHE_HIT;
                continue;
            }
            
            //캐쉬에 저장되어있지 않은 데이터라면
            cache.add(s);
            answer += CACHE_MISS;
            
            if(cache.size() > cacheSize){  //캐쉬가 꽉 찼을 때
                cache.removeFirst();
            }
        }
        
        return answer;
    }
}