import java.util.*;

class Solution {

    static Map<Integer, Integer> car = new TreeMap<>((a,b) -> a - b);
    static int[] fees;
    
    public int[] solution(int[] fees, String[] records) {
        
        this.fees = fees;
        
        //차랑별 누적 주차 시간
        for(String record : records){
            String[] str = record.split(" ");
            int time = Integer.parseInt(str[0].substring(0,2))*60 + Integer.parseInt(str[0].substring(3,5));
            int name = Integer.parseInt(str[1]);

            int previous = car.getOrDefault(name, 0);
            
            if(str[2].equals("IN")){
                car.put(name, previous - time);
            }
            else{   //OUT
                car.put(name, previous + time);
            }
        }
        
        
        //주차 요금 계산
        int[] answer = new int[car.size()];
        int idx = 0;
        for(Integer name : car.keySet()){
            answer[idx++] = calculate(name);
        }
        
        return answer;
    }
    
    public static int calculate(int name){
        int parking_time = car.get(name);
        if(parking_time <= 0){
            parking_time += 1439;       //23:59 출차
        }
        if(parking_time <= fees[0]){    //기본 시간 이하
            return fees[1];
        }
        //기본 시간 이상
        parking_time = (int)Math.ceil((double)(parking_time - fees[0]) / fees[2]);
        return fees[1] + parking_time * fees[3];
    }
}