class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap();
        for(String s: strs) {
            char[] ch = s.toCharArray();
            // sort by character
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(map.containsKey(key)) map.get(key).add(s);
            else {
                map.put(key, new ArrayList<String>());
                map.get(key).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
