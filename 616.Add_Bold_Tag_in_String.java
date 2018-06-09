class Solution {
    class Interval {
		int start, end;
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
    
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList();
        int i = -1;
        for(String d: dict) {
            i = s.indexOf(d, i);
            while (i != -1) {
        		intervals.add(new Interval(i, i + d.length()));
        		i +=1;
        		i = s.indexOf(d, i);
        	}
        }
        
        intervals = merge(intervals);
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for(Interval j : intervals) {
            sb.append(s.substring(prev, j.start));
            sb.append("<b>");
            sb.append(s.substring(j.start, j.end));
            sb.append("</b>");
            prev = j.end;
        }
        if (prev < s.length()) {
        	sb.append(s.substring(prev));
        }
        return sb.toString();
    }
}
