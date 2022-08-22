import java.util.*;
import java.io.*;

class Main{

	public static void main(String[] args){
		String lines[] = new String[]{
			"2016-09-15 20:59:57.421 0.351s",
			"2016-09-15 20:59:58.233 1.181s",
			"2016-09-15 20:59:58.299 0.8s",
			"2016-09-15 20:59:58.688 1.041s",
			"2016-09-15 20:59:59.591 1.412s",
			"2016-09-15 21:00:00.464 1.466s",
			"2016-09-15 21:00:00.741 1.581s",
			"2016-09-15 21:00:00.748 2.31s",
			"2016-09-15 21:00:00.966 0.381s",
			"2016-09-15 21:00:02.066 2.62s"
		};
		Solution sol = new Solution();
		System.out.println(sol.solution(lines));
	}
}


class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        Time[] times = new Time[lines.length];
        for(int i = 0; i<lines.length; i++){
            String line = lines[i];
            int[] times_ = getStartEndTime(line);
            int startTime = times_[0];
            int endTime = times_[1];
            times[i] = new Time(startTime, endTime);
        }
        for(int i = 0; i<times.length; i++){
            Time target = times[i];
            Time curTime = new Time(target.endTime, target.endTime+999);
            int count = 0;
            int test = 0;
			if(i == 1)
				System.out.printf("%d %d ====\n", curTime.startTime, curTime.endTime);
            for(int j = 0; j<times.length; j++){
                if(curTime.isContains(times[j])){
                    test += (int)Math.pow(10, j) * 1;
                	count++;
                }
				//
				if(i == 1){
					System.out.printf("%d %d %b\n", times[j].startTime, times[j].endTime, curTime.isContains(times[j]));
				}
            }
            answer = Math.max(answer, count);
        }
    	return answer;
    }
    
    public int[] getStartEndTime(String line){
     	StringTokenizer st = new StringTokenizer(line);
        String dateStr = st.nextToken();
        String timeStr = st.nextToken();
        String durationStr = st.nextToken();
        
        int endTime = 0;
        int[] infos_ = new int[]{100000000, 10000000, 0, 1000000, 100000, 0, 10000, 1000, 0, 100, 10, 1};
        for(int i = 0; i<infos_.length; i++){
            int value = timeStr.charAt(i) - '0';
            endTime += value * infos_[i];
        }
        
        int duration = 0; 
        int[] infos__ = new int[]{1000, 0, 100, 10, 1};
        for(int i = 0; i<infos__.length ; i++){
            if(durationStr.charAt(i) == 's')
                break;
            int value = durationStr.charAt(i) - '0';
            duration += value * infos__[i];
        }
        int startTime = endTime - duration + 1;
        
        return new int[]{startTime, endTime};
    }
}

class Time implements Comparable<Time>{
    int startTime;
    int endTime;
    Time(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    boolean isContains(Time o){
    	return 1L * (this.startTime - o.endTime) * (this.endTime - o.startTime) <= 0L;
    }
    
    @Override
    public int compareTo(Time o){
        return (this.endTime - o.endTime);
    }
}
