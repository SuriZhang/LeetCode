class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 0) return true;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                if(map.get(ch) != t.charAt(i)) return false;
            } else {
                if(map.containsValue(t.charAt(i))) return false;
                map.put(ch, t.charAt(i));
            }
        }
        return true;
    }
}
// idea: check if a char is already in the dict && maps to the same char as encountered
// catch: remember to check if map already contains value t.charAt(i) 
// 	=> consider the case "abc" "aaa", if we do not check containsValue, it will return true
// if map does not containsValue(t.charAt(i)) add new entry 
