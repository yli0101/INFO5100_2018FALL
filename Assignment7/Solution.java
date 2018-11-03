package question4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List <Interval> merge (List<Interval> intervals) {
		List<Interval> list = new ArrayList<>();
		
		if(intervals == null) 
			return list;
		
		int[] start = new int[intervals.size()];
		int[] end = new int[intervals.size()];
		
		for(int i = 0; i < intervals.size(); i++) {
			start[i] = intervals.get(i).start;
			end[i] = intervals.get(i).end;
		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		int i = 0;
		while(i < intervals.size()) {
			int st = start[i];
			
			while(i < intervals.size() - 1 && start[i + 1] <= end[i])
				i++;
			
			list.add(new Interval(st, end[i]));
			i++;
		}
		return list;
    }
    
    public static void main(String[] args) {
    	Interval[] test = new Interval[4];
    	test[1] = new Interval(1,3);
    	test[2] = new Interval(2,6);
    	test[3] = new Interval(8,10);
    	test[4] = new Interval(15,18);
    	
    	List<Interval> test1 = new ArrayList<>();
    	test1.add(test[0]);
    	test1.add(test[1]);
    	test1.add(test[2]);
    	test1.add(test[3]);
    	
    	
    	List<Interval> result = merge(test1);
    	for(Interval interval : result)
			System.out.print(interval.start + "," + interval.end + " ");
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

