/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution { 
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.end - o2.end;
        }
    });
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i - 1].end > intervals[i].start) return false;
        }
        return true;
    }
}


// sample 4ms submission
public boolean canAttendMeetings(Interval[] intervals) {
        int len=intervals.length;
        if(len==0){
            return true;
        }
        int[]begin=new int[len];
        int[]stop=new int[len];
        for(int i=0;i<len;i++){
            begin[i]=intervals[i].start;
            stop[i]=intervals[i].end;
        }
	// sort start & end time to check overlap
        Arrays.sort(begin);
        Arrays.sort(stop);
        int endT=0;

        for(int i=1;i<len;i++){
            if(begin[i]<stop[i-1]){
                return false;
            }
        }
        return true;
    }

