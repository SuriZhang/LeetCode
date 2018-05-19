class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        if(s.length() == 0 || s.length() == 1) return s.length();
        // use LinkedListMap to pertain order of insertion
        Map<Character, Integer> longest = new LinkedHashMap<>();
        int start = 0;
        for(int cur = 0; cur < s.length(); ++cur) {
            if(longest.containsKey(s.charAt(cur))) {
                // reset start to be next index of the duplicate one in longest 
                start = longest.get(s.charAt(cur)) > start ? longest.get(s.charAt(cur)) : start;
            }
            // cannot return longest.size() as max size, since we are not removing any previous charater from the map
            max = cur-start+1 > max ? cur-start+1 : max;
            // add new char or update value 
            // map(character, index+1)
            longest.put(s.charAt(cur), cur+1);
        }
        System.out.println(longest);
        return max;
    }
}

